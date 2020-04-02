package com.github.dhaval2404.form_validation.rule

/**
 * Rule to check if validate maximum input text length
 *
 * This rule can be used validate text which has variable text length.
 * e.g. Phone Number
 *
 * @author Dhaval Patel
 * @version 1.0
 * @since 28 March 2020
 */
class MaxLengthRule : BaseRule {

    private var mLength = 0

    constructor(length: Int, errorRes: Int) : super(errorRes) {
        this.mLength = length
    }

    constructor(length: Int, error: String) : super(error) {
        this.mLength = length
    }

    override fun validate(text: String?) = text?.length != null && text.length <= mLength

}
