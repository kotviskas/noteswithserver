package com.dvach.lab2

import android.app.DatePickerDialog
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.appcompat.app.AlertDialog
import androidx.navigation.fragment.findNavController
import com.dvach.lab2.recyclerAdapter.InputValidation
import com.dvach.lab2.models.AppDatabase
import com.dvach.lab2.models.objRetrofit
import com.dvach.lab2.pojo.*
import kotlinx.android.synthetic.main.dialog_layout.view.*
import kotlinx.android.synthetic.main.fragment_create_note.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.util.*
import kotlin.collections.ArrayList


class CreateNoteFragment : Fragment() {
    var kaef: Boolean = false
    lateinit var sPref: SharedPreferences
    var savedToken: String? = null
    var kaef2: Boolean = false
    var priorityList: ArrayList<Priority>? = ArrayList()
    var priorityNames: ArrayList<String> = ArrayList()
    var categoryList: ArrayList<Category>? = ArrayList()
    var categoryNames: ArrayList<String> = ArrayList()
    lateinit var adapter: ArrayAdapter<String>
    lateinit var adapter2: ArrayAdapter<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        adapter = ArrayAdapter<String>(
            requireContext(),
            R.layout.spinnertext, priorityNames!!
        )

        adapter2 = ArrayAdapter<String>(
            requireContext(), R.layout.spinnertext, categoryNames!!
        )

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_create_note, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        lottieAnimationView.playAnimation()

        adapter.setDropDownViewResource(R.layout.spinnertext)
        prioritetSpinner.adapter = adapter


        loadText()
        var note: Task? = null
        arguments?.let {
            note = CreateNoteFragmentArgs.fromBundle(it).argNote
            if (note != null) {
                kaef2 = true
            }
        }

        priorityList?.add(
            Priority(
                0,
                "Importantt",
                resources.getColor(R.color.redCard).toString()
            )
        )
        priorityNames.add("Importantt")
        adapter.notifyDataSetChanged()

        GlobalScope.launch(Dispatchers.Main) {
            priorityList = withContext(Dispatchers.IO) {
                try {
                    savedToken?.let {
                        objRetrofit.createRetrofit().getAllPriorities("Bearer " + it)
                    } as ArrayList<Priority>

                } catch (e: Exception) {
                    e.printStackTrace()
                    null
                }

            }
            if (priorityList == null) {
                priorityList = ArrayList()
                priorityList?.add(
                    Priority(
                        3,
                        "Very important",
                        resources.getColor(R.color.yellowCard).toString()
                    )
                )
                priorityList?.add(
                    Priority(
                        4,
                        "Not important",
                        resources.getColor(R.color.greenCard).toString()
                    )
                )
                priorityList?.add(
                    Priority(
                        5,
                        "May be never",
                        resources.getColor(R.color.blueCard).toString()
                    )
                )
            }

            if (priorityNames[0] == "Importantt") {
                priorityNames.removeAt(0)
            }

            priorityList?.forEach {
                priorityNames.add(it.namePriority)
            }

            if (note != null) {
                var flag: Int = 0
                var index: Int = 0
                priorityNames.forEach {
                    if (priorityNames[flag] == note?.priority?.namePriority) {
                        index = flag
                    }
                    flag++
                }
                var str: String = priorityNames[0]
                priorityNames[index] = str
                priorityNames[0] = note?.priority!!.namePriority
            }
            adapter.notifyDataSetChanged()
        }


        var category : Category

        categoryList?.add(Category("Категория задачи", 0))
        categoryNames.add("Категория задачи")


        adapter2.setDropDownViewResource(R.layout.spinnertext)
        categorySpinner.adapter = adapter2

        GlobalScope.launch(Dispatchers.Main) {
            categoryList = withContext(Dispatchers.IO) {
                try {
                    savedToken?.let {
                        objRetrofit.createRetrofit().getAllCategories("Bearer " + it)
                    } as ArrayList<Category>?
                } catch (e: Exception) {
                    e.printStackTrace()
                    null
                }

            }
            if (categoryList == null) {
                categoryList = AppDatabase.getDatabase(requireContext()).CategoryDao()
                    .getAllNames() as ArrayList<Category>?
                return@launch
            }
            categoryList?.forEach {
                categoryNames.add(it.nameCategory)
            }
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
                        if (categoryNames[flag] == note?.category?.nameCategory) {
                            index = flag
                        }
                        flag++
                    }
                    var ctr = categoryNames[0]
                    categoryNames[index] = ctr
                    categoryNames[0] = note?.category!!.nameCategory
                }
            }

            adapter2.notifyDataSetChanged()
        }

        nameEditText.setText(note?.title)
        noteTextEditText.setText(note?.description)
        if (note != null) {
            var str = "До " + Date(note?.deadline!! * 1000)
            dateEditText.setText(str)
        }


        val c = Calendar.getInstance()
        val year = c.get(Calendar.YEAR)
        val month = c.get(Calendar.MONTH)
        val day = c.get(Calendar.DAY_OF_MONTH)

        var date: Date? = null
        addDate.setOnClickListener {
            val dpd = DatePickerDialog(
                requireContext(),
                DatePickerDialog.OnDateSetListener { view, year, monthOfYear, dayOfMonth ->
                    dateEditText.setText("" + dayOfMonth + "." + month + "." + year)

                },
                year,
                month,
                day
            )
            dpd.show()
            date = c.time
        }

        addCategory.setOnClickListener {
            val dialog = LayoutInflater.from(requireContext()).inflate(R.layout.dialog_layout, null)
            val builder = AlertDialog.Builder(requireContext())
                .setView(dialog)
            val alertDialog = builder.show()

            dialog.saveTextView.setOnClickListener {
                alertDialog.dismiss()
                val title = dialog.addCategoryEditText.text.toString()



                GlobalScope.launch(Dispatchers.Main) {
                    var category1 = withContext(Dispatchers.IO) {
                        try {
                            savedToken?.let {
                                objRetrofit.createRetrofit().createCategory(
                                    "Bearer " + it,
                                    CategoryForm(title)
                                )
                            }
                        } catch (e: Exception) {
                            e.printStackTrace()
                            null
                        }

                    }

                    if (category1 != null) {
                        AppDatabase.getDatabase(requireContext()).CategoryDao().insert(category1)
                        categoryList?.add(category1)
                        categoryNames.add(category1.nameCategory)

                        if (categoryNames[0] == "Категория задачи") {
                            categoryNames.removeAt(0)
                            adapter2.notifyDataSetChanged();
                        }
                    }


                    return@launch

                }
                adapter2.notifyDataSetChanged();
            }

            dialog.cancelTextView.setOnClickListener {
                alertDialog.dismiss()
            }


        }

        backImg.setOnClickListener { findNavController().popBackStack() }

        saveNoteBtn.setOnClickListener {
            var validation = InputValidation(requireContext())
            if (validation.isInputEditTextFilled(
                    nameEditText,
                    textInputLayout,
                    "Введите заголовок"
                ) && validation.isInputEditTextFilled(
                    noteTextEditText,
                    emaiInputLayout,
                    "Добавьте описание"
                )
                && validation.isSpinnerFilled(
                    categorySpinner,
                    ""
                ) && categorySpinner.selectedItem.toString() != "Категория задачи"
            ) {
                lottieLayout.visibility = View.VISIBLE
                lottieAnimationView.playAnimation()

                var noteForSave = Task("", "", 0, 0, categoryList!![0], priorityList!![0], 0, 0)

                noteForSave.title = nameEditText.text.toString()
                noteForSave.description = noteTextEditText.text.toString()
                if (date!=null) {
                    noteForSave.deadline = ((date!!.time / 1000))
                }
                else {
                    noteForSave.deadline=note!!.deadline
                }
                    noteForSave.done = 0

                var needPriority: Priority? = null
                priorityList?.forEach {
                    if (it.namePriority == prioritetSpinner.selectedItem) {
                        needPriority = it
                    }
                }

                var needCategory: Category? = null
                categoryList?.forEach {
                    if (it.nameCategory == categorySpinner.selectedItem) {
                        needCategory = it
                    }
                }

                noteForSave.priority = needPriority!!
                noteForSave.category = needCategory!!

                if (!kaef2) {
                    GlobalScope.launch(Dispatchers.Main) {
                        var note1 = withContext(Dispatchers.IO) {
                            try {
                                savedToken?.let {
                                    objRetrofit.createRetrofit().createTask(
                                        "Bearer " + it,
                                        TaskForm(
                                            noteForSave.title,
                                            noteForSave.description,
                                            noteForSave.done,
                                            noteForSave.deadline,
                                            noteForSave.category.idCategory,
                                            noteForSave.priority.idPriority
                                        )
                                    )
                                }
                            } catch (e: Exception) {
                                e.printStackTrace()
                                null
                            }

                        }

                        AppDatabase.getDatabase(this@CreateNoteFragment.requireActivity()).NoteDao()
                            .insert(noteForSave)
                        findNavController().popBackStack()
                        return@launch

                    }

                } else {
                    GlobalScope.launch(Dispatchers.Main) {
                        var note1 = withContext(Dispatchers.IO) {
                            try {
                                savedToken?.let {
                                    objRetrofit.createRetrofit().updateTask(
                                        "Bearer " + it,
                                        note!!.id,
                                        TaskForm(
                                            noteForSave.title,
                                            noteForSave.description,
                                            noteForSave.done,
                                            noteForSave.deadline,
                                            noteForSave.category.idCategory,
                                            noteForSave.priority.idPriority
                                        )
                                    )
                                }
                            } catch (e: Exception) {
                                e.printStackTrace()
                                null
                            }

                        }
                        if (note1 != null) {
                            AppDatabase.getDatabase(requireContext()).NoteDao().insert(noteForSave)
                        }
                        findNavController().popBackStack()
                        return@launch
                    }
                }


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

