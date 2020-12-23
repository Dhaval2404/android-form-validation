package com.github.dhaval2404.form_validation.validation

import android.view.View
import android.widget.CheckBox
import android.widget.TextView
import com.github.dhaval2404.form_validation.adapter.CheckBoxAdapter
import com.github.dhaval2404.form_validation.adapter.TextInputLayoutAdapter
import com.github.dhaval2404.form_validation.adapter.TextViewAdapter
import com.github.dhaval2404.form_validation.adapter.ViewDataAdapter
import com.github.dhaval2404.form_validation.rule.BaseRule
import com.google.android.material.textfield.TextInputLayout

/**
 * Form Validator Class
 *
 *
 * @author Dhaval Patel
 * @version 1.0
 * @since 28 March 2020
 */
class FormValidator {

    companion object {

        /**
         * Get the new instance of FormValidator
         */
        fun getInstance() = FormValidator()
    }

    /**
     * Map View with Rules
     */
    private val mValidationFields = LinkedHashMap<View, List<BaseRule>>()

    /**
     * Registry class used to Extract Data from UI Widgets
     */
    private val mRegistry = LinkedHashMap<Class<out View>, Any>()

    /**
     * Validation Error Listener
     */
    private var mErrorListener: ((List<ValidationError>) -> Unit)? = null

    init {
        // Add Base Widgets and Its Adapters
        mRegistry[CheckBox::class.java] = CheckBoxAdapter()
        mRegistry[TextView::class.java] = TextViewAdapter()
        mRegistry[TextInputLayout::class.java] = TextInputLayoutAdapter()
    }

    /**
     * Add UI widget and its Rules
     *
     * @param view Android Widget on which validation will be applied
     * @param rule Rules to applied on Widget data
     */
    fun addField(view: View, vararg rule: BaseRule): FormValidator {
        mValidationFields[view] = rule.toList()
        return this
    }

    /**
     * Listen to validation error, For custom behaviours
     *
     * @param errorListener Listener Interface
     */
    fun setErrorListener(errorListener: (List<ValidationError>) -> Unit): FormValidator {
        this.mErrorListener = errorListener
        return this
    }

    /**
     * Initiate Validations
     *
     * @return true is all validations will be passes else false
     */
    fun validate(): Boolean {
        val validations = applyValidation()
        mErrorListener?.invoke(validations)
        return validations.isEmpty()
    }

    /**
     * Apply Validation
     *
     * @return List<ValidationError> UI widget on which validation failed
     */
    private fun applyValidation(): List<ValidationError> {
        val errors = ArrayList<ValidationError>()
        for (field in mValidationFields) {
            val text = getText(field.key)
            var status = true
            for (rule in field.value) {
                if (!rule.validate(text)) {
                    errors.add(ValidationError(field.key, rule.getError(field.key.context)))
                    status = false
                    break
                }
            }

            // Set Error
            if (status) setError(field.key, null)
        }
        setErrors(errors)
        return errors
    }

    /**
     * Set error on UI Widget
     */
    private fun setErrors(validations: List<ValidationError>) {
        for (validation in validations) {
            setError(validation.view, validation.error)
        }
    }

    /**
     *
     * @param clazz Get ViewDataAdapter class from UI Widget Class
     */
    @Suppress("UNCHECKED_CAST")
    private fun getViewDataAdapter(clazz: Class<out View>): ViewDataAdapter<View>? {
        if (mRegistry.containsKey(clazz))
            return mRegistry[clazz] as ViewDataAdapter<View>

        val parentClass = clazz.superclass
        return if (parentClass == Object::class.java) {
            null
        } else {
            getViewDataAdapter(parentClass as Class<out View>)
        }
    }

    /**
     * Get text from View
     *
     * @param view View UI Widget
     * @return String get text content from UI Widget
     */
    private fun getText(view: View): String? {
        return getViewDataAdapter(view::class.java)?.getData(view)
    }

    /**
     * Set Error on View
     *
     * @param view View UI Widget
     * @param error String error to set on UI Widget
     */
    private fun setError(view: View, error: String?) {
        getViewDataAdapter(view::class.java)?.setError(view, error)
    }
}
