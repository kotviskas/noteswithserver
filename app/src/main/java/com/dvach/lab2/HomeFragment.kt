package com.dvach.lab2

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.dvach.lab2.recyclerAdapter.RecyclerAdapter
import com.dvach.lab2.models.*
import com.dvach.lab2.pojo.Category
import com.dvach.lab2.pojo.Task
import com.dvach.lab2.pojo.TaskForm
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class HomeFragment : Fragment(), RecyclerAdapter.OnItemClick, RecyclerAdapter.OnCheck {

    lateinit var sPref: SharedPreferences
    var kaef: Boolean = false
    var flag = false
    var items: ArrayList<Item> = ArrayList<Item>()
    lateinit var adapter: RecyclerAdapter
    var categories: List<Category>? = null
    var tasks: List<Task>? = null
    var savedToken: String? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        adapter = RecyclerAdapter(items, this@HomeFragment, this@HomeFragment)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        floatingActionButton.setOnClickListener {
            val act = HomeFragmentDirections.actionHomeFragmentToCreateNoteFragment()
            findNavController().navigate(act)
        }
        recyclerView.layoutManager = GridLayoutManager(requireContext(), 1)
        recyclerView.adapter = adapter

        exitImage.setOnClickListener {
            sPref = requireActivity().getSharedPreferences("kek", Context.MODE_PRIVATE)
            sPref.edit().remove("token").apply();
            //удалить все из бд
            AppDatabase.getDatabase(requireContext()).clearAllTables()
            startActivity(
                Intent(
                    requireContext(),
                    SplashActivity::class.java
                )
            )
        }

        val itemTouchHelperCallback: ItemTouchHelper.SimpleCallback =
            object : ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT) {
                override fun onMove(
                    recyclerView: RecyclerView,
                    viewHolder: RecyclerView.ViewHolder,
                    target: RecyclerView.ViewHolder
                ): Boolean {
                    return false
                }

                override fun onSwiped(
                    viewHolder: RecyclerView.ViewHolder,
                    direction: Int
                ) {
                    var pos: Int = viewHolder.adapterPosition

                    if (items[pos].type == 1) {
                        GlobalScope.launch(Dispatchers.Main) {
                            var note1 = withContext(Dispatchers.IO) {
                                try {
                                    savedToken?.let {
                                        objRetrofit.createRetrofit()
                                            .deleteTask("Bearer " +it, (items[pos].note_object as Task).id)
                                    }
                                } catch (e: Exception) {
                                    e.printStackTrace()
                                    null
                                }

                            }
                        }
                        AppDatabase.getDatabase(requireActivity().applicationContext).NoteDao()
                            .delete(items[pos].note_object as Task)
                        items.removeAt(pos)
                        adapter.notifyDataSetChanged()
                    }
                }
            }
        ItemTouchHelper(itemTouchHelperCallback).attachToRecyclerView(recyclerView)

    }

    override fun onResume() {
        super.onResume()
        loadText()

        //получение тасков
        GlobalScope.launch(Dispatchers.Main) {
            tasks = withContext(Dispatchers.IO) {
                try {
                    savedToken?.let { objRetrofit.createRetrofit().getAllTasks("Bearer " + it) }
                } catch (e: Exception) {
                    Log.d("error", e.message.toString())
                    AppDatabase.getDatabase(requireContext()).NoteDao().getAllTitles()

                }

            }
            //получение категорий
            if (tasks != null) {
                categories = withContext(Dispatchers.IO) {
                    try {
                        savedToken?.let {
                            objRetrofit.createRetrofit().getAllCategories("Bearer " + it)
                        }
                    } catch (e: Exception) {
                        Log.d("error", e.message.toString())
                        AppDatabase.getDatabase(requireContext()).CategoryDao().getAllNames()
                    }
                }
                items.clear()
                categories?.forEach {
                    items.add(Item(0, it))
                    val category = it
                    tasks?.forEach {
                        if (it.category == category) {
                            items.add(Item(1, it))
                        }
                    }
                }
                adapter.notifyDataSetChanged()
            }
            if (items.size != 0) {
                imageView.visibility = View.INVISIBLE
                textView.visibility = View.INVISIBLE
                recyclerView.visibility = View.VISIBLE
            } else {
                imageView.visibility = View.VISIBLE
                textView.visibility = View.VISIBLE
                recyclerView.visibility = View.INVISIBLE
            }
        }

    }

    override fun noteClick(task: Task) {
        val action = HomeFragmentDirections.actionHomeFragmentToAboutNoteFragment(task)
        findNavController().navigate(action)
    }

    override fun changeCheck(task: Task) {
        GlobalScope.launch(Dispatchers.Main) {
            val answer = withContext(Dispatchers.IO) {
                try {
                    objRetrofit.createRetrofit().updateTask(
                        "Bearer " +savedToken!!,
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
                    null
                }

            }
            if (answer != null) {
                AppDatabase.getDatabase(requireContext()).NoteDao().insert(task)
            }
        }
    }

    fun loadText() {
        sPref = requireActivity().getSharedPreferences("kek", Context.MODE_PRIVATE)
        if (sPref.contains("token")) {
            savedToken = sPref.getString("token", "")
            kaef = true
            //   Toast.makeText(this, "Text loaded", Toast.LENGTH_SHORT).show()
        }
    }
}
