package com.github.dhaval2404.form_validation.rule

/**
 * Rule to check if validate input text length
 *
 * This rule can be used validate text which has fixed size.
 * e.g. OTP, In some cases Phone Number
 *
 * @author Dhaval Patel
 * @version 1.0
 * @since 28 March 2020
 */
class LengthRule : BaseRule {

    /**
     * Length to compare with text content
     */
    private var mLength = 0

    constructor(length: Int, errorRes: Int) : super(errorRes) {
        this.mLength = length
    }

    constructor(length: Int, error: String) : super(error) {
        this.mLength = length
    }

    /**
     * Check if text length is equal to content length
     *
     * @param text String Text to validate
     * @return Boolean return true if text is equal to provide length else return false
     */
    override fun validate(text: String?) = isEqualLength(text, mLength)

    companion object {

        /**
         * Check if text length is equal to content length
         *
         * @param text String Text to validate
         * @param length Int length of the content to match Text length
         * @return Boolean return true if text is equal to provide length else return false
         */
        fun isEqualLength(text: String?, length: Int): Boolean {
            return text?.length != null && text.length == length
        }

    }

}
