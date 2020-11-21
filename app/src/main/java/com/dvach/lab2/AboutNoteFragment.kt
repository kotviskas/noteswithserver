package com.dvach.lab2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.dvach.lab2.models.Task
import kotlinx.android.synthetic.main.fragment_about_note.*


class AboutNoteFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_about_note, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        backImg.setOnClickListener { findNavController().popBackStack() }

      //  val intent = intent
       // val note = intent.getSerializableExtra("note") as Note
        val note = Task()


        noteNameTextView.text = note.title
        categoryNameTextView.text = note.category
        textTextView.text = note.description
        if (note.check == false) {
            checkTextView.text = getString(R.string.nedone)
            //checkTextView.setTextColor(getColor(R.color.redCard))

        } else {
            checkTextView.text = getString(R.string.done)
            //checkTextView.setTextColor(getColor(R.color.greenCard))
        }
        var str = "До " + note.done
        dateTextView.text = str
        prioritetTextView.text = note.prioritet
        changeImageView.setOnClickListener {

           // i.putExtra("note", note)
           // i.putExtra("user", user)

            findNavController().navigate(R.id.createNoteFragment)
            findNavController().popBackStack()

        }
    }
}
