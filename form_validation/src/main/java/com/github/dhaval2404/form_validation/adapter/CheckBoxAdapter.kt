package com.github.dhaval2404.form_validation.adapter

import android.widget.CheckBox

/**
 * Adapter returns a [java.lang.String] from [CheckBox]
 *
 * @author Dhaval Patel
 * @version 1.0
 * @since 29 March 2020
 */
class CheckBoxAdapter : ViewDataAdapter<CheckBox> {

    /**
     * Get CheckBox Data
     *
     * @param view CheckBox
     * @return String Return "true" is CheckBox is Checked else "false"
     */
    override fun getData(view: CheckBox): String {
        return view.isChecked.toString()
    }

    /**
     * Set Error for [CheckBox] Widget
     *
     * @param view CheckBox Widget on which error will be set
     * @param message String Error message to set on CheckBox Widget
     */
    override fun setError(view: CheckBox, message: String?) {
        view.error = message
    }
}
