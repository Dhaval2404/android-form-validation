package com.github.dhaval2404.form_validation.adapter

import com.google.android.material.textfield.TextInputLayout

/**
 * Adapter returns a [java.lang.String] from [TextInputLayout]
 *
 * @author Dhaval Patel
 * @version 1.0
 * @since 29 March 2020
 */
class TextInputLayoutAdapter : ViewDataAdapter<TextInputLayout> {

    /**
     * Get TextInputLayout's EditText text content
     *
     * @param view TextInputLayout
     * @return String TextInputLayout's EditText text content
     */
    override fun getData(view: TextInputLayout): String {
        return view.editText?.text.toString()
    }

    /**
     * Set Error for [TextInputLayout] Widget
     *
     * @param view TextInputLayout Widget on which error will be set
     * @param message String Error message to set on TextInputLayout Widget
     */
    override fun setError(view: TextInputLayout, message: String?) {
        view.error = message
    }
}
