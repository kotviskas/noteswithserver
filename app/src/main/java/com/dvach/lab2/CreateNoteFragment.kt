package com.dvach.lab2

import android.app.DatePickerDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.appcompat.app.AlertDialog
import androidx.navigation.fragment.findNavController
import com.dvach.lab2.adapter.InputValidation
import com.dvach.lab2.models.AppDatabase
import com.dvach.lab2.models.Category
import com.dvach.lab2.models.Priority
import com.dvach.lab2.models.Task
import kotlinx.android.synthetic.main.dialog_layout.view.*
import kotlinx.android.synthetic.main.fragment_create_note.*
import java.util.*
import kotlin.collections.ArrayList


class CreateNoteFragment : Fragment() {
    var note = Task("","",1,213, Category("",1), Priority(1,"sdsa","000000"),1,1,)
    var kaef: Boolean = false
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


        var list2 = ArrayList<String>(Arrays.asList(*resources.getStringArray(R.array.prioritet)))
        var category = Category("dsa",1)

        var categoryList: ArrayList<String> =
            AppDatabase.getDatabase(requireContext()).CategoryDao()
                .getAllNames() as ArrayList<String>
        if (categoryList.size == 0) {
            categoryList.add("Категория задачи")
        }
       // val intent = intent
       /* if (intent.hasExtra("note")) {
            note = intent.getSerializableExtra("note") as Note
            nameEditText.setText(note.name)
            noteTextEditText.setText(note.text)
            dateEditText.setText(note.date)
            kaef = true
            var flag: Int = 0
            var index: Int = 0
            list2.forEach {
                if (list2[flag] == note.prioritet) {
                    index = flag
                }
                flag++
            }
            var str: String = list2[0]
            list2[index] = str
            list2[0] = note.prioritet

            flag = 0
            index = 0
            categoryList.forEach {
                if (categoryList[flag] == note.category) {
                    index = flag
                }
                flag++
            }
            str = categoryList[0]
            categoryList[index] = str
            categoryList[0] = note.category

        }*/


        var spinner: Spinner = prioritetSpinner
        var adapter: ArrayAdapter<String> = ArrayAdapter<String>(
            requireContext(),
            R.layout.spinnertext, list2
        )
        adapter.setDropDownViewResource(R.layout.spinnertext)
        spinner.adapter = adapter

        var spinner2: Spinner = categorySpinner

        val adapter2: ArrayAdapter<String> = ArrayAdapter<String>(
            requireContext(), R.layout.spinnertext, categoryList
        )

        adapter2.setDropDownViewResource(R.layout.spinnertext)
        spinner2.adapter = adapter2

        if (kaef == true) {
            var list2: ArrayList<String>

        }
        val c = Calendar.getInstance()
        val year = c.get(Calendar.YEAR)
        val month = c.get(Calendar.MONTH)
        val day = c.get(Calendar.DAY_OF_MONTH)

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


        }

        addCategory.setOnClickListener {

            val dialog = LayoutInflater.from(requireContext()).inflate(R.layout.dialog_layout, null)

            val builder = AlertDialog.Builder(requireContext())
                .setView(dialog)
            val alertDialog = builder.show()

            dialog.saveTextView.setOnClickListener {
                alertDialog.dismiss()
                category.nameCategory = dialog.addCategoryEditText.text.toString()
                AppDatabase.getDatabase(requireContext()).CategoryDao().insert(category)
                categoryList.add(category.nameCategory)
                if (categoryList[0] == "Категория задачи") {
                    categoryList.removeAt(0)
                    adapter2.notifyDataSetChanged();
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
                    spinner2,
                    ""
                ) && spinner2.selectedItem.toString() != "Категория задачи"
            ) {
                lottieLayout.visibility = View.VISIBLE
                lottieAnimationView.playAnimation()
                note.title = nameEditText.text.toString()
                note.description = noteTextEditText.text.toString()
               // note.deadline = dateEditText.text.toString()
                note.priority = spinner.selectedItem as Priority
                note.category = spinner2.selectedItem as Category

             /*   if (note.priority == "Срочно") {
                    note.color = resources.getColor(R.color.redCard)
                }
                if (note.prioritet == "Важно") {
                    note.color = resources.getColor(R.color.yellowCard)
                }
                if (note.prioritet == "Нужно") {
                    note.color = resources.getColor(R.color.greenCard)
                }
                if (note.prioritet == "Пофиг") {
                    note.color = resources.getColor(R.color.blueCard)
                }*/

                AppDatabase.getDatabase(requireContext()).NoteDao().insert(note)
                findNavController().popBackStack()
            }
        }

    }


}

