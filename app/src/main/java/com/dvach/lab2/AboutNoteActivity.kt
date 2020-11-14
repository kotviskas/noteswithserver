package com.dvach.lab2

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.dvach.lab2.models.Note
import com.dvach.lab2.models.User
import kotlinx.android.synthetic.main.activity_about_note.*


class AboutNoteActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about_note)
        backImg.setOnClickListener { finish() }

        val intent = intent
        val note = intent.getSerializableExtra("note") as Note
        var user = intent.getSerializableExtra("user") as User


        noteNameTextView.text = note.name
        categoryNameTextView.text = note.category
        textTextView.text = note.text
        if (note.check == false) {
            checkTextView.text = getString(R.string.nedone)
            checkTextView.setTextColor(getColor(R.color.redCard))

        } else {
            checkTextView.text = getString(R.string.done)
            checkTextView.setTextColor(getColor(R.color.greenCard))
        }
        var str = "До " + note.date
        dateTextView.text = str
        prioritetTextView.text = note.prioritet
        changeImageView.setOnClickListener {
            val i = Intent(this, NoteActivity::class.java)
            i.putExtra("note", note)
            i.putExtra("user", user)

            startActivity(i)
            finish()

        }


    }
}
