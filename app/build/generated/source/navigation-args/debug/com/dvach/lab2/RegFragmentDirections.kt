package com.dvach.lab2

import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections

class RegFragmentDirections private constructor() {
  companion object {
    fun actionRegToLogin(): NavDirections = ActionOnlyNavDirections(R.id.action_reg_to_login)
  }
}
