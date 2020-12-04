package com.dvach.lab2.homepage

import android.app.Activity
import android.content.Context
import android.content.SharedPreferences
import android.util.Log
import androidx.recyclerview.widget.RecyclerView
import com.dvach.lab2.MainActivity
import com.dvach.lab2.models.AppDatabase
import com.dvach.lab2.models.Item
import com.dvach.lab2.models.objRetrofit
import com.dvach.lab2.pojo.Category
import com.dvach.lab2.pojo.Task
import com.dvach.lab2.pojo.TaskForm
import kotlinx.coroutines.*

class HomePageModel {
    lateinit var sPref: SharedPreferences
    var kaef: Boolean = false
    var flag = false
    var items: ArrayList<Item> = ArrayList<Item>()

    var categories: List<Category>? = null
    var tasks: List<Task>? = null
    var savedToken: String? = null
    var isSynchronized = true
    var flag2 = true

    suspend fun getItems(context: Context, activity: Activity): ArrayList<Item> {
        tasks =
            try {
                savedToken?.let {
                    objRetrofit.createRetrofit(
                        context,
                        activity
                    ).getAllTasks()
                }

            } catch (e: Exception) {
                Log.d("error", e.message.toString())
                flag2 = false
                AppDatabase.getDatabase(context).NoteDao().getAllTitles()
            }

        if (flag2 && isSynchronized) {
            flag2 = false
            AppDatabase.getDatabase(context).NoteDao().deleteAll()
            AppDatabase.getDatabase(context).NoteDao()
                .insertAll(tasks as ArrayList<Task>)
        }
        //получение категорий
        if (tasks != null) {
            flag = true
            categories =
                try {
                    savedToken?.let {
                        objRetrofit.createRetrofit(context, activity)
                            .getAllCategories()
                    }
                } catch (e: Exception) {
                    Log.d("error", e.message.toString())
                    flag = false
                    AppDatabase.getDatabase(context).CategoryDao().getAllNames()
                }

            if (flag) {
                AppDatabase.getDatabase(context).CategoryDao().deleteAll()
                AppDatabase.getDatabase(context).CategoryDao()
                    .insertAll(categories as ArrayList<Category>)
            }
            items.clear()
            categories?.forEach {
                items.add(Item(0, it))
                val category = it
                tasks?.forEach { task ->
                    if (task.category == category && task.created != -3) {
                        items.add(Item(1, task))
                    }
                }
            }

        }
        return items
    }

    suspend fun whenSwiped(
        viewHolder: RecyclerView.ViewHolder,
        context: Context,
        activity: Activity
    ) {
        var pos: Int = viewHolder.adapterPosition

        if (items[pos].type == 1) {
            var note1 =
                try {
                    var item = items[pos].note_object
                    savedToken?.let {
                        objRetrofit.createRetrofit(
                            context,
                            activity
                        )
                            .deleteTask((items[pos].note_object as Task).id)

                    }
                    AppDatabase.getDatabase(activity.applicationContext)
                        .NoteDao()
                        .delete((items[pos].note_object as Task))
                } catch (e: Exception) {
                    e.printStackTrace()
                    (items[pos].note_object as Task).created = -3
                    isSynchronized = false
                    AppDatabase.getDatabase(context).NoteDao()
                        .insert((items[pos].note_object as Task))
                    null
                }
            items.removeAt(pos)
        }
    }

    fun getItemsArray(): ArrayList<Item> {
        return items
    }

    fun deleteToken(activity: Activity) {
        sPref = activity.getSharedPreferences("kek", Context.MODE_PRIVATE)
        sPref.edit().remove("token").apply();
    }

    fun clearDatabase(context: Context) {
        AppDatabase.getDatabase(context).clearAllTables()
    }

    suspend fun synchronize(context: Context, activity: Activity) {
        isSynchronized = false

        while (!isSynchronized) {
             withContext(Dispatchers.Main) {
                 MainActivity.enableSynchronizationAnimation()
             }

            val api = objRetrofit.createRetrofit(context, activity)
            val tasks = AppDatabase.getDatabase(context).NoteDao().getAllTitles()
            val tasksToChange = tasks.filter { s -> s.created == -1 }
            val createdTasks = tasksToChange.filter { s -> s.id == -1 }
            val changedTasks = tasksToChange.filter { s -> s.id != -1 }
            val deletedTasks = tasks.filter { s -> s.created == -3 }

            var error = false
            deletedTasks.forEach {
                try {
                    api.deleteTask(it.id)
                } catch (e: java.lang.Exception) {
                    error = true
                }
            }
            createdTasks.forEach {
                try {
                    api.createTask(
                        TaskForm(
                            it.title,
                            it.description,
                            it.done,
                            it.deadline,
                            it.category.idCategory,
                            it.priority.idPriority
                        )
                    )
                } catch (e: java.lang.Exception) {
                    error = true
                }
            }
            changedTasks.forEach {
                try {
                    api.updateTask(
                        it.id,
                        TaskForm(
                            it.title,
                            it.description,
                            it.done,
                            it.deadline,
                            it.category.idCategory,
                            it.priority.idPriority
                        )
                    )
                } catch (e: java.lang.Exception) {
                    error = true
                }
            }
            if (!error) {
                try {
                    val updatedTasks = api.getAllTasks()
                    AppDatabase.getDatabase(context).NoteDao().deleteAll()
                    AppDatabase.getDatabase(context).NoteDao()
                        .insertAll(updatedTasks as ArrayList<Task>)
                    isSynchronized = true
                    Log.d(
                        "Synchronization",
                        "Successfully"
                    )
                } catch (e: java.lang.Exception) {
                    error = true
                }
            }
              withContext(Dispatchers.Main) {
                  MainActivity.disableSynchronizationAnimation()
              }
            if (error) {
                delay(10000)
            }
        }

    }

    fun loadText(activity: Activity) {
        sPref = activity.getSharedPreferences("kek", Context.MODE_PRIVATE)
        if (sPref.contains("token")) {
            savedToken = sPref.getString("token", "")
            kaef = true
            //   Toast.makeText(this, "Text loaded", Toast.LENGTH_SHORT).show()
        }
    }

    fun changeTaskDone(task: Task, context: Context, activity: Activity) {
        GlobalScope.launch(Dispatchers.Main) {
            val answer = withContext(Dispatchers.IO) {
                try {
                    objRetrofit.createRetrofit(context, activity).updateTask(
                        task.id,
                        TaskForm(
                            task.title,
                            task.description,
                            task.done,
                            task.deadline,
                            task.category.idCategory,
                            task.priority.idPriority
                        )
                    )
                } catch (e: Exception) {
                    e.printStackTrace()
                    task.created=-1
                    null
                }

            }

            AppDatabase.getDatabase(context).NoteDao().insert(task)

        }
    }
}