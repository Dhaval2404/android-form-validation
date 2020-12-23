package com.github.dhaval2404.form_validation.rule

/**
 * Widely used rule, To check if user has entered input or not.
 *
 * Validate input field to be not empty
 *
 * @author Dhaval Patel
 * @version 1.0
 * @since 28 March 2020
 */
class NonEmptyRule : BaseRule {

    constructor(errorRes: Int) : super(errorRes)

    constructor(error: String) : super(error)

    /**
     * Check if text is Empty or not
     *
     * @param text String Text to validate
     * @return Boolean return true if text is not null and not blank else return false
     */
    override fun validate(text: String?) = isNonEmpty(text)

    companion object {

        /**
         * Check if text is Empty or not
         *
         * @param text String Text to validate
         * @return Boolean return true if text is not null and not blank else return false
         */
        fun isNonEmpty(text: String?): Boolean {
            return !text.isNullOrBlank()
        }
    }
}
