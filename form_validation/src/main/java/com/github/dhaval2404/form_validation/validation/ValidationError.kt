package com.github.dhaval2404.form_validation.validation

import android.view.View

/**
 * Validation Error
 *
 * @author Dhaval Patel
 * @version 1.0
 * @since 28 March 2020
 */
data class ValidationError(val view: View, val error: String)
