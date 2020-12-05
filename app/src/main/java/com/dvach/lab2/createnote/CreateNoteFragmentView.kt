package com.dvach.lab2.createnote

import android.app.Activity
import android.app.DatePickerDialog
import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.FragmentActivity
import androidx.navigation.fragment.findNavController
import com.dvach.lab2.createnote.CreateNoteFragmentViewArgs
import com.dvach.lab2.R
import com.dvach.lab2.recyclerAdapter.InputValidation
import com.dvach.lab2.pojo.*
import kotlinx.android.synthetic.main.dialog_layout.view.*
import kotlinx.android.synthetic.main.fragment_create_note.*
import java.text.DateFormat
import java.util.*


class CreateNoteFragmentView : Fragment(), CreateNoteFragmentInterface.View {

    var kaef2: Boolean = false
    var date1: Date? = null
    lateinit var presenter: CreateNoteFragmentInterface.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter = CreateNoteFragmentPresenter(this@CreateNoteFragmentView)
        presenter.onCreate()
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
        //lottieAnimationView.playAnimation()

        presenter.onViewCreated()

        addDate.setOnClickListener {
            presenter.onAddDate()
        }

        addCategory.setOnClickListener {
            presenter.onAddCategory()
        }

        backImg.setOnClickListener { presenter.onBackImg() }

        saveNoteBtn.setOnClickListener {
            presenter.onSaveNoteBtn(kaef2,date1)
        }

    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.onDestroy()
    }

    override fun onAddCategory(){
        val dialog = LayoutInflater.from(requireContext()).inflate(R.layout.dialog_layout, null)
        val builder = AlertDialog.Builder(requireContext())
            .setView(dialog)
        val alertDialog = builder.show()

        dialog.saveTextView.setOnClickListener {
            val title = dialog.addCategoryEditText.text.toString()
            presenter.onDialogSaveTextView(title,alertDialog)
        }

        dialog.cancelTextView.setOnClickListener {
            presenter.onDialogBack(alertDialog)
        }
    }

    override fun setSpinnerAdapters(adapter:ArrayAdapter<String>, adapter2:ArrayAdapter<String>){
        prioritetSpinner.adapter = adapter
        categorySpinner.adapter = adapter2
    }

    override fun setTask(): Task? {
        var note: Task? = null
        arguments?.let {
            note = CreateNoteFragmentViewArgs.fromBundle(it).argNote
            if (note != null) {
                kaef2 = true
                nameEditText.setText(note?.title)
                noteTextEditText.setText(note?.description)
                val date = Date(note?.deadline!! * 1000)
                val str = DateFormat.getDateInstance(DateFormat.FULL).format(date)
                dateEditText.setText(str)

            }
        }
        return note
    }

    override fun getNameEditText(): String {
        return nameEditText.text.toString()
    }

    override fun getNoteTextEditText(): String {
        return noteTextEditText.text.toString()
    }

    override fun getPrioritetSpinner(): String {
        return prioritetSpinner.selectedItem as String
    }
    override fun getCategorySpinner(): String {
        return categorySpinner.selectedItem as String
    }


    override fun getDate() {
        var c = Calendar.getInstance()
        var year = c.get(Calendar.YEAR)
        var month = c.get(Calendar.MONTH)
        var day = c.get(Calendar.DAY_OF_MONTH)
        val dpd = DatePickerDialog(
            requireContext(),
            DatePickerDialog.OnDateSetListener { view, mYear, monthOfYear, dayOfMonth ->
                dateEditText.setText("" + dayOfMonth + "." + (monthOfYear + 1) + "." + mYear)
                date1 = Date(mYear-1900,monthOfYear,dayOfMonth+0,0,0,0)
                // date = Date(Myear,monthOfYear+1,dayOfMonth)

            },
            year,
            month,
            day
        )
        dpd.show()
    }

    override fun hideDialog(alertDialog: AlertDialog) {
        alertDialog.dismiss()
    }



    override fun showAnimation() {
        lottieLayout.visibility = View.VISIBLE
        lottieAnimationView.playAnimation()
    }

    override fun isValidate(): Boolean {
        var validation = InputValidation(requireContext())
        return (validation.isInputEditTextFilled(
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
        ) && categorySpinner.selectedItem.toString() != "Категория задачи")
    }

    override fun getContextT(): Context {
        return requireContext()
    }

    override fun getActivityF(): FragmentActivity {
        return requireActivity()
    }


    override fun goBack() {
        findNavController().popBackStack()
    }

}

