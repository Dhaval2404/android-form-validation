package com.github.dhaval2404.form_validation.rule

/**
 * Rule to check if Input text is equal to the provided text.
 *
 * This rule can be used to confirm input text.
 * e.g. Confirm Password, Confirm Email
 *
 * @author Dhaval Patel
 * @version 1.0
 * @since 28 March 2020
 */
class EqualRule : BaseRule {

    private var mText: String? = null

    constructor(text: String, errorRes: Int) : super(errorRes) {
        this.mText = text
    }

    constructor(text: String, error: String) : super(error) {
        this.mText = text
    }

    override fun validate(text: String?) = text == mText
}
