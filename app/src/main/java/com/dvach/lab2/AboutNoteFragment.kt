package com.dvach.lab2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.dvach.lab2.pojo.Category
import com.dvach.lab2.pojo.Priority
import com.dvach.lab2.pojo.Task
import kotlinx.android.synthetic.main.fragment_about_note.*
import java.util.*


class AboutNoteFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_about_note, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        backImg.setOnClickListener { findNavController().popBackStack() }

        var note:Task?=null
        arguments?.let{
           note=AboutNoteFragmentArgs.fromBundle(it).argNote
        }

        noteNameTextView.text = note?.title
        categoryNameTextView.text = note?.category.toString()
        textTextView.text = note?.description
        if (note?.done == 0) {
            checkTextView.text = getString(R.string.nedone)
            //checkTextView.setTextColor(getColor(R.color.redCard))

        } else {
            checkTextView.text = getString(R.string.done)
            //checkTextView.setTextColor(getColor(R.color.greenCard))
        }
        var str = "До " + Date(note?.deadline!!*1000 )

        dateTextView.text = str
        prioritetTextView.text = note?.priority.toString()

        changeImageView.setOnClickListener {
           // i.putExtra("note", note)
            val action = AboutNoteFragmentDirections.actionAboutNoteFragmentToCreateNoteFragment(note)
            findNavController().navigate(action)
            findNavController().popBackStack()

        }
    }
}
