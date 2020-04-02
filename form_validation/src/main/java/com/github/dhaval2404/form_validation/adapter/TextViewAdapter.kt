package com.github.dhaval2404.form_validation.adapter

import android.widget.TextView
import androidx.appcompat.widget.AppCompatEditText

/**
 * Adapter returns a [java.lang.String] from [android.widget.TextView]s or
 * its subclasses, usually [android.widget.EditText] or [AppCompatEditText].
 *
 * @author Dhaval Patel
 * @version 1.0
 * @since 29 March 2020
 *
 */
class TextViewAdapter : ViewDataAdapter<TextView> {

    /**
     * Get TextView  text content
     *
     * @param view TextView
     * @return String TextView text content
     */
    override fun getData(view: TextView): String {
        return view.text.toString()
    }

    /**
     * Set Error for [TextView] Widget
     *
     * @param view TextView Widget on which error will be set
     * @param message String Error message to set on TextView Widget
     */
    override fun setError(view: TextView, message: String?) {
        view.error = message
    }
}
