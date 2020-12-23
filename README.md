# ✔UI form validation library for Android

[![Download](https://api.bintray.com/packages/dhaval2404/maven/android-form-validation/images/download.svg) ](https://bintray.com/dhaval2404/maven/android-form-validation/_latestVersion)
[![Releases](https://img.shields.io/github/release/dhaval2404/android-form-validation/all.svg?style=flat-square)](https://github.com/Dhaval2404/android-form-validation/releases)
[![API](https://img.shields.io/badge/API-21%2B-brightgreen.svg?style=flat)](https://android-arsenal.com/api?level=19)
![Language](https://img.shields.io/badge/language-Kotlin-orange.svg)
[![PRWelcome](https://img.shields.io/badge/PRs-welcome-brightgreen.svg)](https://github.com/Dhaval2404/android-form-validation)
[![ktlint](https://img.shields.io/badge/code%20style-%E2%9D%A4-FF4081.svg)](https://ktlint.github.io/)
![License](https://img.shields.io/github/license/Dhaval2404/android-form-validation.svg)
![Build Status](https://github.com/Dhaval2404/android-form-validation/workflows/build%20debug/badge.svg)
[![Android Arsenal]( https://img.shields.io/badge/Android%20Arsenal-ImagePicker-green.svg?style=flat)]( https://android-arsenal.com/details/1/8098)
[![Twitter](https://img.shields.io/twitter/url/https/github.com/Dhaval2404/android-form-validation.svg?style=social)](https://twitter.com/intent/tweet?text=Checkout%20the%20UI%20form%20validation%20library%20for%20Android.%20https%3A%2F%2Fgithub.com%2FDhaval2404%2Fandroid-form-validation)

<div align="center">
  <sub>Built with ❤︎ by
  <a href="https://twitter.com/Dhaval2404">Dhaval Patel</a> and
  <a href="https://github.com/dhaval2404/android-form-validation/graphs/contributors">
    contributors
  </a>
</div>
<br/>

Yet another UI form validation library for Android. It is highly customizable and easy to use. This library will works with **TextView**, **EditText**, **AppCompatEditText**, **TextInputEditText**, **TextInputLayout** and **CheckBox**. This library is designed in such a way that Its easy to add support for new widgets and add new rules.

# 💻Usage


1. Gradle dependency:

	```groovy
	implementation 'com.github.dhaval2404:android-form-validation:1.0'
	```

2. The **android-form-validation** configuration is created using the builder pattern.

	```kotlin
    private fun isValidForm(): Boolean {
        return FormValidator.getInstance()
            .addField(firstNameEt, NonEmptyRule(R.string.error_empty_first_name))
            .addField(lastNameEt, NonEmptyRule(R.string.error_empty_last_name))
            .addField(
                emailEtLyt,
                NonEmptyRule("Please enter Email"),
                EmailRule(R.string.error_invalid_email)
            )
            .addField(
                passwordEtLyt,
                NonEmptyRule("Please enter Password"),
                PasswordRule("Please provide strong Password")
            )
            .addField(
                confirmPasswordEtLyt,
                NonEmptyRule("Please enter Password"),
                EqualRule(
                    confirmPasswordEt.text.toString(),
                    "Password and Confirm password must match"
                )
            )
            .addField(
                phoneNumberEt,
                NonEmptyRule("Please enter Phone Number"),
                LengthRule(10, "Please enter valid Phone Number")
            )
            .addField(
                termsOfUseCB,
                CheckedRule("Accept terms of use")
            )
            .setErrorListener {
                // Require only for CheckBox with Toast or Custom View Only
                for (error in it) {
                    if (error.view is CheckBox) {
                        (error.view as CheckBox).error = null
                        Toast.makeText(applicationContext, error.error, Toast.LENGTH_SHORT).show()
                    }
                    Log.e("Error", error.toString())
                }
            }
            .validate()
    }
    ```

# 📐Supported Rules:

* CheckedRule(Used with CheckBox only)

  ```kotlin
  addField(termsOfUseCheckbox, CheckedRule("Accept terms of use"))
  ```

* EmailRule

  ```kotlin
  addField(emailEditText, EmailRule("Please enter valid Email"))
  ```

* EqualRule
 	```kotlin
  // Combile 2 rules for Confirm Password Validation
  // Check if Password is valid and Password match with Confirm Password
  addField(confirmPasswordEditText,
  		PasswordRule(PasswordPattern.ALPHA_NUMERIC, "Please provide strong Password"),
  		EqualRule(passwordEditText.text.toString(), "Password not matching")
  )
  ```

 	```kotlin
  // Combile 2 rules for Confirm Email Validation
  // Check if Email is valid and Email match with Confirm Email
  addField(emailEditText,
  		EmailRule("Please enter valid Email"),
  		EqualRule(confirmEmailEditText.text.toString(), "Email not matching")
  )
  ```

* LengthRule

  ```kotlin
  addField(phoneNumberEditText, LengthRule(10, "Please enter valid Phone Number"))
  ```

* MaxLengthRule

  ```kotlin
  addField(messageEditText, MaxLengthRule(50, "Message should be less than 50 character long"))
  ```

* MinLengthRule

  ```kotlin
  addField(messageEditText, MinLengthRule(10, "Please enter message with at least 10 character"))
  ```

  ```kotlin
  // Check if Phone Number Length is between 10-13
  addField(phoneNumberEditText,
		MinLengthRule(10, "Please enter valid Phone Number"),
		MaxLengthRule(13, "Please enter valid Phone Number"))
  ```

* NumberRule

  ```kotlin
  addField(priceEditText, NumberRule("Please enter valid Price"))
  ```

* NonEmptyRule

  ```kotlin
  addField(firstNameEditText, NonEmptyRule("Please enter First Name"))
  ```

* PasswordRule

  ```kotlin
  // Password can have any characters
  addField(passwordEditText, PasswordRule("Please enter Password"))
  ```

  ```kotlin
  // Password should have alphabets and numeric character both
  addField(passwordEditText, PasswordRule(PasswordPattern.ALPHA_NUMERIC, "Please provide strong Password"))
  ```

* RegexRule

  ```kotlin
  addField(usernameEditText, RegexRule(RegexRule.USERNAME_PATTERN, "Please enter valid Username"))
  ```

  ```kotlin
  addField(usernameEditText, RegexRule("^[a-zA-Z0-9_-]{3,16}",  "Please enter valid Username"))
  ```



# 💥Compatibility

  * Library - Android Kitkat 4.4+ (API 19)
  * Sample - Android Kitkat 4.4+ (API 19)

# ✔️Changelog

### Version: 1.0

  * Initial Build

### Let us know!

We'll be really happy if you sent us links to your projects where you use our library. Just send an email to **dhavalpatel244@gmail.com** And do let us know if you have any questions or suggestion regarding the library.

## License

    Copyright 2020, Dhaval Patel

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

         http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
