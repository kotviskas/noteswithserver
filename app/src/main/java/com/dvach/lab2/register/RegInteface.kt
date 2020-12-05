package com.dvach.lab2.register

import android.content.Context
import androidx.fragment.app.FragmentActivity
import com.dvach.lab2.pojo.UserRegistrationForm

interface RegInteface {
    interface View{
        fun startMainActivity()
        fun getEmail(): String
        fun showError()
        fun showEmailError()
        fun createRegForm(): UserRegistrationForm
        fun validation(): Boolean
        fun navigateToLoginFragment()
        fun getContext() : Context
        fun getActivityF(): FragmentActivity
    }

    interface Presenter{
        fun onAddUserBtn()
        fun onLoginTextView()
        fun onDestroy()
    }
}