package com.example.googlefilechunks.ui

object RegistrationUtils
{
    private val existingUser = listOf<String>("vamsi","reddy","palni")

    fun validateRegistrationInput(userName:String,password:String,cnfPasword:String):Boolean
    {
        if (userName.isEmpty() || password.isEmpty()){
            return false
        }
        if (userName in existingUser){
            return false
        }
        if (password!=cnfPasword){
            return false
        }
        if (password.count { it.isDigit() } < 2){
            return false
        }
        return true
    }

}