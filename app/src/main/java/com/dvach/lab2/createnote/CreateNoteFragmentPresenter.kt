package com.dvach.lab2.createnote

import android.widget.ArrayAdapter
import com.dvach.lab2.R
import com.dvach.lab2.pojo.Category
import com.dvach.lab2.pojo.Priority
import com.dvach.lab2.pojo.Task
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.util.*
import kotlin.collections.ArrayList

class CreateNoteFragmentPresenter(var view: CreateNoteFragmentView?) {
    lateinit var adapter: ArrayAdapter<String>
    lateinit var adapter2: ArrayAdapter<String>
    var model = CreateNoteFragmentModel(view!!.requireContext(),view!!.requireActivity())
    var note:Task? = null

    fun onViewCreated(){
        note = view!!.setTask()
        view!!.setSpinnerAdapters(adapter,adapter2)
        model.loadText()
        model.addFirstPriority()
        model.addFirstCategory()
        adapter.notifyDataSetChanged()
        GlobalScope.launch(Dispatchers.Main) {
            model.getPriority()
            model.changeFirstPriority(note)
            adapter.notifyDataSetChanged()
        }
        GlobalScope.launch(Dispatchers.Main) {
            model.getCategories()
            model.changeFirstCategory(note)
            adapter2.notifyDataSetChanged()
        }

    }

    fun onCreate(){
        setAdapter()
    }

    fun onDestroy() {
        view = null
    }

    fun onSaveNoteBtn(kaef2:Boolean, date: Date?){
        if (view!!.isValidate()) {
            view!!.showAnimation()
            val noteForSave = createNewTask(date, note, view!!.getNameEditText(), view!!.getNoteTextEditText(), view!!.getPrioritetSpinner(), view!!.getCategorySpinner(), model.priorityList, model.categoryList)
            if (!kaef2) {
                GlobalScope.launch(Dispatchers.Main) {
                    model.createTask(noteForSave)
                    view!!.goBack()
                }

            } else {
                GlobalScope.launch(Dispatchers.Main) {
                    model.changeTask(note!!, noteForSave)
                    view!!.goBack()
                    view!!.goBack()
                }
            }

        }
    }

    fun onAddCategory(){
        view!!.onAddCategory()
    }

    fun onAddDate() {
        view!!.getDate()
    }

    fun onDialogSaveTextView(title: String, alertDialog: androidx.appcompat.app.AlertDialog){
        view!!.hideDialog(alertDialog)
        GlobalScope.launch(Dispatchers.Main) {
            model.createCategory(title)
            adapter2.notifyDataSetChanged();
        }
        adapter2.notifyDataSetChanged();
    }

    fun onDialogBack(alertDialog: androidx.appcompat.app.AlertDialog){
        view!!.hideDialog(alertDialog)
    }

    fun onBackImg(){
        view!!.goBack()
    }

    private fun setAdapter(){
        adapter = ArrayAdapter<String>(
            view!!.requireContext(),
            R.layout.spinnertext, model.priorityNames
        )
        adapter2 = ArrayAdapter<String>(
            view!!.requireContext(), R.layout.spinnertext, model.categoryNames
        )
        adapter.setDropDownViewResource(R.layout.spinnertext)
        adapter2.setDropDownViewResource(R.layout.spinnertext)
    }

    fun createNewTask(date: Date?, note: Task?, nameEditText : String,  noteTextEditText:String, prioritetSpinner : String, categorySpinner: String, priorityList: ArrayList<Priority>?, categoryList: ArrayList<Category>?): Task {
        var noteForSave = Task("", "", 0, 0, categoryList!![0], priorityList!![0], 0, 0)

        noteForSave.title = nameEditText
        noteForSave.description = noteTextEditText
        if (date != null) {
            noteForSave.deadline = ((date.time / 1000))
        } else {
            noteForSave.deadline = note!!.deadline
        }
        noteForSave.done = 0

        var needPriority: Priority? = null
        priorityList.forEach {
            if (it.namePriority == prioritetSpinner) {
                needPriority = it
            }
        }

        var needCategory: Category? = null
        categoryList.forEach {
            if (it.nameCategory == categorySpinner) {
                needCategory = it
            }
        }

        noteForSave.priority = needPriority!!
        noteForSave.category = needCategory!!

        return noteForSave
    }
}