package com.dvach.lab2

import android.os.Bundle
import android.os.Parcelable
import androidx.navigation.NavArgs
import com.dvach.lab2.pojo.Task
import java.io.Serializable
import java.lang.UnsupportedOperationException
import kotlin.Suppress
import kotlin.jvm.JvmStatic

data class CreateNoteFragmentArgs(
  val argNote: Task? = null
) : NavArgs {
  @Suppress("CAST_NEVER_SUCCEEDS")
  fun toBundle(): Bundle {
    val result = Bundle()
    if (Parcelable::class.java.isAssignableFrom(Task::class.java)) {
      result.putParcelable("arg_note", this.argNote as Parcelable?)
    } else if (Serializable::class.java.isAssignableFrom(Task::class.java)) {
      result.putSerializable("arg_note", this.argNote as Serializable?)
    }
    return result
  }

  companion object {
    @JvmStatic
    fun fromBundle(bundle: Bundle): CreateNoteFragmentArgs {
      bundle.setClassLoader(CreateNoteFragmentArgs::class.java.classLoader)
      val __argNote : Task?
      if (bundle.containsKey("arg_note")) {
        if (Parcelable::class.java.isAssignableFrom(Task::class.java) ||
            Serializable::class.java.isAssignableFrom(Task::class.java)) {
          __argNote = bundle.get("arg_note") as Task?
        } else {
          throw UnsupportedOperationException(Task::class.java.name +
              " must implement Parcelable or Serializable or must be an Enum.")
        }
      } else {
        __argNote = null
      }
      return CreateNoteFragmentArgs(__argNote)
    }
  }
}
