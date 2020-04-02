package com.github.dhaval2404.form_validation.adapter

import android.view.View

interface ViewDataAdapter<VIEW : View> {

    /**
     * Extract and return the appropriate data from a given [android.view.View].
     *
     * @param view The [android.view.View] from which contains the data that we are
     * interested in.
     *
     * @return The interested data.
     */
    fun getData(view: VIEW): String

    /**
     * Set Error for UI Widget
     *
     * @param view VIEW UI Widget on which error will be set
     * @param message String Error message to set on UI Widget
     */
    fun setError(view: VIEW, message: String?)
}
