package com.example.myappnote

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import com.google.android.material.floatingactionbutton.FloatingActionButton

class NewNoteActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_note)


        val floatingActionButton = findViewById<FloatingActionButton>(R.id.floatingActionButton)
        floatingActionButton.setOnClickListener {
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