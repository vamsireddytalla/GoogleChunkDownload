package com.example.googlefilechunks.ui


import com.google.common.truth.Truth.assertThat
import org.junit.Test

class RegistrationUtilsTest {
    @Test
    fun `empty user name returns false`() {
        val result = RegistrationUtils.validateRegistrationInput("", "1234", "1234")
        assertThat(result).isFalse()
    }

    @Test
    fun `valid user name and correctly repeated password returns true`() {
      val result = RegistrationUtils.validateRegistrationInput("Talla","1234","1234")
        assertThat(result).isTrue()
    }

    @Test
    fun `username already exists returns false`(){
        val result = RegistrationUtils.validateRegistrationInput("vamsi","1234","1234")
        assertThat(result).isFalse()
    }


}