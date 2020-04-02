package com.github.dhaval2404.form_validation.rule

import android.content.Context
import androidx.annotation.StringRes

/**
 * Base class for all validation rules
 *
 * @author Dhaval Patel
 * @version 1.0
 * @since 28 March 2020
 */
abstract class BaseRule private constructor() {

    /**
     * Error String Resource
     */
    @StringRes
    protected var errorRes: Int = 0

    /**
     * Error String
     */
    protected var error: String? = null

    constructor(@StringRes errorRes: Int) : this() {
        this.errorRes = errorRes
    }

    constructor(error: String) : this() {
        this.error = error
    }

    /**
     * Get Error error
     */
    open fun getError(context: Context): String {
        if (errorRes != 0) {
            return context.getString(errorRes)
        }
        return error ?: ""
    }

    /**
     * Validate text input based on Rule
     */
    abstract fun validate(text: String?): Boolean
}
