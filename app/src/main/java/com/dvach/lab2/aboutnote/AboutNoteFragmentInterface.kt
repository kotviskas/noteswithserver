package com.dvach.lab2.aboutnote

import android.content.Context
import android.widget.ArrayAdapter
import android.widget.DatePicker
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.dvach.lab2.pojo.Task

interface AboutNoteFragmentInterface
{
    interface View {
        fun navigateToCreateNoteFragment(note: Task)
        fun goBack()
        fun setText(note: Task)
    }

    interface Presenter {
        fun onViewCreated(note: Task)
        fun onDestroy()
        fun onGoBack()
        fun changeImageView(note: Task)
    }

}