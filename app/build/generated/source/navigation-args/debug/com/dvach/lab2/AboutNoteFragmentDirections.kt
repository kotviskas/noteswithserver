package com.dvach.lab2

import android.os.Bundle
import android.os.Parcelable
import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections
import com.dvach.lab2.pojo.Task
import java.io.Serializable
import kotlin.Int
import kotlin.Suppress

class AboutNoteFragmentDirections private constructor() {
  private data class ActionAboutNoteFragmentToCreateNoteFragment(
    val argNote: Task? = null
  ) : NavDirections {
    override fun getActionId(): Int = R.id.action_aboutNoteFragment_to_createNoteFragment

    @Suppress("CAST_NEVER_SUCCEEDS")
    override fun getArguments(): Bundle {
      val result = Bundle()
      if (Parcelable::class.java.isAssignableFrom(Task::class.java)) {
        result.putParcelable("arg_note", this.argNote as Parcelable?)
      } else if (Serializable::class.java.isAssignableFrom(Task::class.java)) {
        result.putSerializable("arg_note", this.argNote as Serializable?)
      }
      return result
    }
  }

  companion object {
    fun actionAboutNoteFragmentToHomeFragment(): NavDirections =
        ActionOnlyNavDirections(R.id.action_aboutNoteFragment_to_homeFragment)

    fun actionAboutNoteFragmentToCreateNoteFragment(argNote: Task? = null): NavDirections =
        ActionAboutNoteFragmentToCreateNoteFragment(argNote)
  }
}
