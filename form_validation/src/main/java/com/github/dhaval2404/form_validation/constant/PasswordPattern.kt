package com.github.dhaval2404.form_validation.constant

/**
 * Password Pattern
 *
 * @author Dhaval Patel
 * @version 1.0
 * @since 31 March 2020
 */
enum class PasswordPattern(val value: String) {
    ANY(".+"),
    NUMERIC("\\d+"),
    ALPHA("\\w+"),
    ALPHA_MIXED_CASE("(?=.*[a-z])(?=.*[A-Z]).+"),
    ALPHA_NUMERIC("(?=.*[a-zA-Z])(?=.*[\\d]).+"),
    ALPHA_NUMERIC_MIXED_CASE("(?=.*[a-z])(?=.*[A-Z])(?=.*[\\d]).+"),
    ALPHA_NUMERIC_SYMBOLS("(?=.*[a-zA-Z])(?=.*[\\d])(?=.*([^\\w]|_)).+"),
    ALPHA_NUMERIC_MIXED_CASE_SYMBOLS("(?=.*[a-z])(?=.*[A-Z])(?=.*[\\d])(?=.*([^\\w]|_)).+")
}

