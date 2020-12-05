package com.dvach.lab2.login

import android.content.Context
import androidx.fragment.app.FragmentActivity
import com.dvach.lab2.pojo.UserLoginForm

interface LogInterface {

        interface View{
            fun navigateToRegFragment()
            fun createLoginForm(): UserLoginForm
            fun startMainActivity()
            fun showError()
            fun isValidate(): Boolean
            fun getContextT() : Context
            fun getActivityF(): FragmentActivity
        }

        interface Presenter{
            fun tryToLogin()
            fun onRegisterText()
            fun onDestroy()
        }

}