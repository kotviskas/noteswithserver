package com.dvach.lab2.createnote

import android.app.Activity
import android.content.Context
import android.widget.ArrayAdapter
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.FragmentActivity
import com.dvach.lab2.pojo.Category
import com.dvach.lab2.pojo.Priority
import com.dvach.lab2.pojo.Task
import java.util.*

interface CreateNoteFragmentInterface {

    interface View {
        fun onAddCategory()
        fun setSpinnerAdapters(adapter: ArrayAdapter<String>, adapter2: ArrayAdapter<String>)
        fun setTask(): Task?
        fun getNameEditText(): String
        fun getNoteTextEditText(): String
        fun getPrioritetSpinner(): String
        fun getCategorySpinner(): String
        fun getDate()
        fun hideDialog(alertDialog: AlertDialog)
        fun showAnimation()
        fun isValidate(): Boolean
        fun goBack()
        fun getContextT() : Context
        fun getActivityF(): FragmentActivity
    }

    interface Presenter {
        fun onViewCreated()
        fun onDestroy()
        fun onCreate()
        fun onSaveNoteBtn(kaef2:Boolean, date: Date?)
        fun onAddCategory()
        fun onAddDate()
        fun onDialogSaveTextView(title: String, alertDialog: androidx.appcompat.app.AlertDialog)
        fun onDialogBack(alertDialog: androidx.appcompat.app.AlertDialog)
        fun onBackImg()
        fun createNewTask(date: Date?, note: Task?, nameEditText : String, noteTextEditText:String, prioritetSpinner : String, categorySpinner: String, priorityList: ArrayList<Priority>?, categoryList: ArrayList<Category>?): Task
    }
}