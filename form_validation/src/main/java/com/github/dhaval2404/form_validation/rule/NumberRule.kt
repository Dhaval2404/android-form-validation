package com.github.dhaval2404.form_validation.rule

/**
 * Rule to check if input text is valid number or not
 *
 *
 * @author Dhaval Patel
 * @version 1.0
 * @since 28 March 2020
 */
class NumberRule : BaseRule {

    constructor(errorRes: Int) : super(errorRes)

    constructor(error: String) : super(error)

    override fun validate(text: String?) = text?.toDoubleOrNull() != null

}
