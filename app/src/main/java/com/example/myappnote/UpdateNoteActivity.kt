package com.example.myappnote

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.TextView

class UpdateNoteActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update_note)

        //..
        val textViewTitle = findViewById<TextView>(R.id.textViewTitle)
        val textViewBody = findViewById<TextView>(R.id.textViewBody)

        val noteTitle = intent.getStringExtra("note_title")
        val noteBody = intent.getStringExtra("note_body")

        textViewTitle.text = noteTitle
        textViewBody.text = noteBody

        val btnClose = findViewById<ImageButton>(R.id.backButton1)
        btnClose.setOnClickListener {
            finish()
        }
    }
}