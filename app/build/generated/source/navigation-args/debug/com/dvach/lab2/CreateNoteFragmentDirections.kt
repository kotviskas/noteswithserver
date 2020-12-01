package com.dvach.lab2

import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections

class CreateNoteFragmentDirections private constructor() {
  companion object {
    fun actionCreateNoteFragmentToHomeFragment(): NavDirections =
        ActionOnlyNavDirections(R.id.action_createNoteFragment_to_homeFragment)
  }
}
