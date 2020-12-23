package com.github.dhaval2404.form_validation.rule

import java.util.regex.Pattern

/**
 * Validate Input field value based on provided regex
 *
 * @author Dhaval Patel
 * @version 1.0
 * @since 28 March 2020
 */
class RegexRule : BaseRule {

    /**
     * Regex Pattern
     */
    private var mRegex: String = ""

    constructor(regex: String, errorRes: Int) : super(errorRes) {
        this.mRegex = regex
    }

    constructor(regex: String, error: String) : super(error) {
        this.mRegex = regex
    }

    override fun validate(text: String?): Boolean {
        return validate(mRegex, text)
    }

    companion object {
        // 1234
        const val DIGIT_ONLY_PATTERN = "^\\d+\$"

        // 12.34
        const val DECIMAL_ONLY_PATTERN = "^\\d*\\.\\d+\$"

        // ABC123
        const val ALPHANUMERIC_PATTERN = "^[a-zA-Z0-9]*\$"

        // Dhaval-_2404
        // Alphanumeric string that may include _ and – having a length of 3 to 16 characters
        const val USERNAME_PATTERN = "^[a-zA-Z0-9_-]{3,16}"

        /**
         * Validate if text content matched the regex
         *
         * @param regex String Regex Pattern
         * @param text String text content to match the regex
         * @return Boolean return true if text matched the regex else return false
         */
        fun validate(regex: String, text: String?): Boolean {
            if (text.isNullOrBlank()) return false

            return Pattern.compile(regex).matcher(text).matches()
        }
    }
}
