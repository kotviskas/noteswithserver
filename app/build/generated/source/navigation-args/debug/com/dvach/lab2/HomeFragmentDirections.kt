package com.dvach.lab2

import android.os.Bundle
import android.os.Parcelable
import androidx.navigation.NavDirections
import com.dvach.lab2.pojo.Task
import java.io.Serializable
import java.lang.UnsupportedOperationException
import kotlin.Int
import kotlin.Suppress

class HomeFragmentDirections private constructor() {
  private data class ActionHomeFragmentToCreateNoteFragment(
    val argNote: Task? = null
  ) : NavDirections {
    override fun getActionId(): Int = R.id.action_homeFragment_to_createNoteFragment

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

  private data class ActionHomeFragmentToAboutNoteFragment(
    val argNote: Task
  ) : NavDirections {
    override fun getActionId(): Int = R.id.action_homeFragment_to_aboutNoteFragment

    @Suppress("CAST_NEVER_SUCCEEDS")
    override fun getArguments(): Bundle {
      val result = Bundle()
      if (Parcelable::class.java.isAssignableFrom(Task::class.java)) {
        result.putParcelable("arg_note", this.argNote as Parcelable)
      } else if (Serializable::class.java.isAssignableFrom(Task::class.java)) {
        result.putSerializable("arg_note", this.argNote as Serializable)
      } else {
        throw UnsupportedOperationException(Task::class.java.name +
            " must implement Parcelable or Serializable or must be an Enum.")
      }
      return result
    }
  }

  companion object {
    fun actionHomeFragmentToCreateNoteFragment(argNote: Task? = null): NavDirections =
        ActionHomeFragmentToCreateNoteFragment(argNote)

    fun actionHomeFragmentToAboutNoteFragment(argNote: Task): NavDirections =
        ActionHomeFragmentToAboutNoteFragment(argNote)
  }
}
