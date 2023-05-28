package com.example.myappnote

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class NewNoteActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_note)


        val btn_saveNewNote = findViewById<Button>(R.id.btn_saveNote)
        btn_saveNewNote.setOnClickListener {
            val noteTitle = findViewById<EditText>(R.id.etNoteTitle).text.toString()
            val noteBody = findViewById<EditText>(R.id.etNoteBody).text.toString()

            val intent = Intent()
            intent.putExtra("noteTitle", noteTitle)
            intent.putExtra("noteBody", noteBody)
            setResult(RESULT_OK, intent)
            finish()
        }

    }

}