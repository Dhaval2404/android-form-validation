package com.github.dhaval2404.form_validation.rule

import com.github.dhaval2404.form_validation.constant.PasswordPattern

/**
 * Validate Password, Provide PasswordPattern as per the requirement
 *
 * @author Dhaval Patel
 * @version 1.0
 * @since 28 March 2020
 */
class PasswordRule : BaseRule {

    /***
     * Password Pattern, Password must have alphabets and digits both
     */
    private var mPattern: PasswordPattern = PasswordPattern.ALPHA_NUMERIC_SYMBOLS

    constructor(errorRes: Int) : super(errorRes)

    constructor(error: String) : super(error)

    constructor(pattern: PasswordPattern, errorRes: Int) : super(errorRes) {
        this.mPattern = pattern
    }

    constructor(pattern: PasswordPattern, error: String) : super(error) {
        this.mPattern = pattern
    }

    override fun validate(text: String?) = isValidPassword(mPattern, text)

    companion object {

        /**
         * Validate Password based on Password Patten
         *
         * @param pattern PasswordPattern
         * @param password String password text
         *
         * @return Boolean, Return true is password matched the pattern else false
         */
        private fun isValidPassword(pattern: PasswordPattern, password: String?): Boolean {
            return RegexRule.validate(pattern.value, password)
        }
    }
}
