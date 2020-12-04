package com.dvach.lab2.createnote

import android.app.Activity
import android.content.Context
import android.content.SharedPreferences
import androidx.navigation.fragment.findNavController
import com.dvach.lab2.R
import com.dvach.lab2.models.AppDatabase
import com.dvach.lab2.models.objRetrofit
import com.dvach.lab2.pojo.*
import kotlinx.android.synthetic.main.fragment_create_note.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.util.*
import kotlin.collections.ArrayList

class CreateNoteFragmentModel(var context: Context, var activity: Activity) {
    var kaef: Boolean = false
    lateinit var sPref: SharedPreferences
    var savedToken: String? = null
    var priorityList: ArrayList<Priority>? = ArrayList()
    var priorityNames: ArrayList<String> = ArrayList()
    var categoryList: ArrayList<Category>? = ArrayList()
    var categoryNames: ArrayList<String> = ArrayList()

    suspend fun getPriority(): ArrayList<String> {
        loadText()
        priorityList = withContext(Dispatchers.IO) {
            try {
                objRetrofit.createRetrofit(context, activity)
                    .getAllPriorities()
                        as ArrayList<Priority>

            } catch (e: Exception) {
                e.printStackTrace()
                null
            }

        }
        if (priorityList == null) {
            priorityList = ArrayList()

            priorityList?.add(
                Priority(
                    2,
                    "Important",
                    "#E7004D"
                )
            )

            priorityList?.add(
                Priority(
                    3,
                    "Very important",
                    "#EF8D09"
                )
            )
            priorityList?.add(
                Priority(
                    4,
                    "Not important",
                    "#2E9C14"
                )
            )
            priorityList?.add(
                Priority(
                    5,
                    "May be never",
                    "#45D3EB"
                )
            )
        }

        priorityList?.forEach {
            priorityNames.add(it.namePriority)
        }
        return priorityNames
    }

    suspend fun getCategories(): ArrayList<String> {
        categoryList = withContext(Dispatchers.IO) {
            try {

                objRetrofit.createRetrofit(context, activity)
                    .getAllCategories()
                        as ArrayList<Category>?
            } catch (e: Exception) {
                e.printStackTrace()
                null
            }

        }
        if (categoryList == null) {
            categoryList = AppDatabase.getDatabase(context).CategoryDao()
                .getAllNames() as ArrayList<Category>?

        }
        categoryList?.forEach {
            categoryNames.add(it.nameCategory)
        }
        return categoryNames
    }

    suspend fun createCategory(title: String) {

        var category1 = withContext(Dispatchers.IO) {
            try {

                objRetrofit.createRetrofit(context, activity)
                    .createCategory(

                        CategoryForm(title)
                    )

            } catch (e: Exception) {
                e.printStackTrace()
                null
            }

        }

        if (category1 != null) {
            AppDatabase.getDatabase(context).CategoryDao().insert(category1)
            categoryList?.add(category1)
            categoryNames.add(category1.nameCategory)

            if (categoryNames[0] == "Категория задачи") {
                categoryNames.removeAt(0)

            }
        }

    }

    suspend fun createTask(noteForSave: Task) {
        val note1 = withContext(Dispatchers.IO) {
            try {

                objRetrofit.createRetrofit(context, activity).createTask(

                    TaskForm(
                        noteForSave.title,
                        noteForSave.description,
                        noteForSave.done,
                        noteForSave.deadline,
                        noteForSave.category.idCategory,
                        noteForSave.priority.idPriority
                    )
                )

            } catch (e: Exception) {
                e.printStackTrace()
                null
            }

        }

        if (note1 != null) {
            AppDatabase.getDatabase(activity).NoteDao()
                .insert(note1)
        } else {
            noteForSave.created = -1
            noteForSave.id = -1

            AppDatabase.getDatabase(activity).NoteDao()
                .insert(noteForSave)
        }

    }

    suspend fun changeTask(note: Task, noteForSave: Task) {
        var note1 = withContext(Dispatchers.IO) {
            try {

                objRetrofit.createRetrofit(context, activity).updateTask(

                    note.id,
                    TaskForm(
                        noteForSave.title,
                        noteForSave.description,
                        noteForSave.done,
                        noteForSave.deadline,
                        noteForSave.category.idCategory,
                        noteForSave.priority.idPriority
                    )
                )

            } catch (e: Exception) {
                e.printStackTrace()
                null
            }

        }
        if (note1 != null) {
            AppDatabase.getDatabase(activity).NoteDao()
                .insert(note1)
        } else {
            noteForSave.created = -1
            noteForSave.id = note!!.id
            AppDatabase.getDatabase(activity).NoteDao()
                .insert(noteForSave)
        }

    }


    fun loadText() {
        sPref = activity.getSharedPreferences("kek", Context.MODE_PRIVATE)
        if (sPref.contains("token")) {
            savedToken = sPref.getString("token", "")
            kaef = true
            //   Toast.makeText(this, "Text loaded", Toast.LENGTH_SHORT).show()
        }
    }

    fun addFirstPriority() {
        priorityList?.add(
            Priority(
                0,
                "Importantt",
                "000000"
            )
        )
        priorityNames.add("Importantt")
    }

    fun changeFirstPriority(note: Task?) {
        if (priorityNames[0] == "Importantt") {
            priorityNames.removeAt(0)
        }

        if (note != null) {
            var flag: Int = 0
            var index: Int = 0
            priorityNames.forEach {
                if (priorityNames[flag] == note.priority.namePriority) {
                    index = flag
                }
                flag++
            }
            val str: String = priorityNames[0]
            priorityNames[index] = str
            priorityNames[0] = note.priority.namePriority
        }
    }


    fun addFirstCategory() {
        categoryList?.add(Category("Категория задачи", 0))
        categoryNames.add("Категория задачи")
    }

    fun changeFirstCategory(note: Task?) {
        if (categoryNames.size == 0) {
            categoryNames.add("Категория задачи")
        } else {
            if (categoryNames[0] == "Категория задачи") {
                categoryNames.removeAt(0)
            }
            if (note != null) {
                var flag = 0
                var index = 0
                categoryNames.forEach {
                    if (categoryNames[flag] == note.category.nameCategory) {
                        index = flag
                    }
                    flag++
                }
                val ctr = categoryNames[0]
                categoryNames[index] = ctr
                categoryNames[0] = note.category.nameCategory
            }
        }
    }
}