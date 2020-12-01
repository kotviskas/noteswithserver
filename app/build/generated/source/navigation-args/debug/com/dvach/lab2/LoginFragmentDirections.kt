package com.dvach.lab2

import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections

class LoginFragmentDirections private constructor() {
  companion object {
    fun actionLoginFragmentToRegFragment(): NavDirections =
        ActionOnlyNavDirections(R.id.action_loginFragment_to_regFragment)

    fun actionLoginToReg(): NavDirections = ActionOnlyNavDirections(R.id.action_login_to_reg)
  }
}
