package com.github.dhaval2404.form_validation

import com.github.dhaval2404.form_validation.rule.EmailRule
import org.junit.Assert
import org.junit.Test

/**
 * Email Rule local unit test, which will execute on the development machine (host).
 *
 * Ref: http://onlinetraining.etestinghub.com/email-validation-test-cases/
 */
class EmailRuleUnitTest {

    @Test
    fun validEmailCase1() {
        Assert.assertTrue(EmailRule.isEmailValid("dhavalpatel.244@gmail.com"))
    }

    @Test
    fun validEmailCase2() {
        Assert.assertTrue(EmailRule.isEmailValid("dhaval@gmail.com"))
    }

    @Test
    fun validEmailCase3() {
        Assert.assertTrue(EmailRule.isEmailValid("firstname-lastname@domain.com"))
    }

    @Test
    fun validEmailCase4() {
        Assert.assertTrue(EmailRule.isEmailValid("email@123.123.123.123"))
    }

    @Test
    fun invalidEmailCase1() {
        //Null or Blank Value
        Assert.assertFalse(EmailRule.isEmailValid(null))
        Assert.assertFalse(EmailRule.isEmailValid(""))
    }

    @Test
    fun invalidEmailCase2() {
        //invalid domain
        Assert.assertFalse(EmailRule.isEmailValid("dhaval@gmail"))
    }

    @Test
    fun invalidEmailCase3() {
        //invalid domain
        Assert.assertFalse(EmailRule.isEmailValid("r@r"))
    }

    @Test
    fun invalidEmailCase4() {
        //atleast 2 character in username
        Assert.assertFalse(EmailRule.isEmailValid("r@r.c"))
    }

    @Test
    fun invalidEmailCase5() {
        //Garbage
        Assert.assertFalse(EmailRule.isEmailValid("#@%^%#@#$@#.com"))
    }

    @Test
    fun invalidEmailCase6() {
        //Missing username
        Assert.assertFalse(EmailRule.isEmailValid("@domain.com"))
    }

    @Test
    fun invalidEmailCase7() {
        //Missing @
        Assert.assertFalse(EmailRule.isEmailValid("email.domain.com"))
    }

    @Test
    fun invalidEmailCase8() {
        //Two @ sign
        Assert.assertFalse(EmailRule.isEmailValid("email@domain@domain.com"))
    }

    @Test
    fun invalidEmailCase9() {
        //Leading dot in address is not allowed
        Assert.assertFalse(EmailRule.isEmailValid(".email@domain.com"))
    }

    @Test
    fun invalidEmailCase10() {
        //Invalid IP format
        Assert.assertFalse(EmailRule.isEmailValid("email@111.222.333.44444\t"))
    }

}
