package com.dvach.lab2.aboutnote

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat.getColor
import androidx.navigation.fragment.findNavController
import com.dvach.lab2.aboutnote.AboutNoteFragmentViewArgs
import com.dvach.lab2.aboutnote.AboutNoteFragmentViewDirections
import com.dvach.lab2.R
import com.dvach.lab2.pojo.Task
import kotlinx.android.synthetic.main.fragment_about_note.*
import java.text.DateFormat
import java.util.*
import kotlin.time.days


class AboutNoteFragmentView : Fragment() {
    lateinit var presenter:AboutNoteFragmentPresenter
    var note : Task? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_about_note, container, false)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        note=getTask()
        presenter = AboutNoteFragmentPresenter(this@AboutNoteFragmentView)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.onViewCreated(note!!)

        backImg.setOnClickListener { presenter.onGoBack() }

        changeImageView.setOnClickListener {
            presenter.changeImageView(note!!)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.onDestroy()
    }

    fun navigateToCreateNoteFragment(note: Task){
        val action =
            AboutNoteFragmentViewDirections.actionAboutNoteFragmentToCreateNoteFragment(
                note
            )
        findNavController().navigate(action)
    }

    fun goBack(){
        findNavController().popBackStack()
    }

    private fun getTask(): Task? {
        var note:Task?=null
        arguments?.let{
             note= AboutNoteFragmentViewArgs.fromBundle(it).argNote
        }
        return note
    }

    fun setText(note: Task){
        noteNameTextView.text = note.title
        categoryNameTextView.text = note.category.nameCategory
        textTextView.text = note.description
        if (note.done == 0) {
            checkTextView.text = getString(R.string.nedone)
            checkTextView.setTextColor(getColor(requireContext(),
                R.color.redCard
            ))

        } else {
            checkTextView.text = getString(R.string.done)
            checkTextView.setTextColor(getColor(requireContext(),
                R.color.greenCard
            ))
        }
        var date = Date(note.deadline*1000 )

        var str = "До " + DateFormat.getDateInstance(DateFormat.FULL).format(date)

        dateTextView.text = str
        prioritetTextView.text = note.priority.namePriority
    }
}
