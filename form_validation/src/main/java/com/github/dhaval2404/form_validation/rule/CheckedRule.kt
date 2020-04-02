package com.github.dhaval2404.form_validation.rule

/**
 * Used with CheckBox Widget, To check if widget is checked or not
 *
 * @author Dhaval Patel
 * @version 1.0
 * @since 28 March 2020
 */
class CheckedRule : BaseRule {

    constructor(errorRes: Int) : super(errorRes)

    constructor(error: String) : super(error)

    /**
     * Check if input text is true of false
     *
     * @param text String value of boolean
     *
     * @return Boolean true if text is 'true' else false
     */
    override fun validate(text: String?) = text?.toBoolean() == true
}
