package com.example.myappnote

import NoteAdapter
import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity(), NoteAdapter.ItemClickListener {

    private lateinit var recyclerView: RecyclerView
    private lateinit var noteAdapter: NoteAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // ...
        val addNoteButton = findViewById<FloatingActionButton>(R.id.floatingActionAdd)
        addNoteButton.setOnClickListener {
            val intent = Intent(this, NewNoteActivity::class.java)
            startActivity(intent)
        }

        // ...

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val noteList = createSampleNoteList()
        noteAdapter = NoteAdapter(noteList)
        recyclerView.adapter = noteAdapter

        //..
        val dividerItemDecoration = DividerItemDecoration(recyclerView.context, DividerItemDecoration.VERTICAL)
        dividerItemDecoration.setDrawable(ContextCompat.getDrawable(recyclerView.context, R.drawable.divider)!!)
        recyclerView.addItemDecoration(dividerItemDecoration)

        //..
        noteAdapter.setItemClickListener(this)

        //..
        val aboutuser = findViewById<ImageView>(R.id.aboutuser)
        aboutuser.setOnClickListener {
            val intent = Intent(this, AboutUserActivity::class.java)
            startActivity(intent)
        }
    }

    private fun createSampleNoteList(): List<Note> {
        // Tạo danh sách các note mẫu
        val sampleList = mutableListOf<Note>()
        sampleList.add(Note("Note 1", "This is the body of Note 1.This is the body oThis is the body of Note 1.This is the body of Note 1.This is the body of Note 1.This is the body of Note 1.This is the body of Note 1.This is the body of Note 1.This is the body of Note 1.This is the body of Note 1."))
        sampleList.add(Note("Note 2", "This is the body of Note 2."))
        sampleList.add(Note("Note 3", "This is the body of Note 3.This is the body of Note 1.This is the body of Note 1.This is the body of Note 1.This is the body of Note 1."))
        sampleList.add(Note("Note 4", "This is the body of Note 1.This is the body of Note 1.This is the body of Note 1.This is the body of Note 1.This is the body of Note 1."))
        sampleList.add(Note("Note 5", "This is the body of Note 2."))
        sampleList.add(Note("Note 6", "This is the body of Note 3.This is the body of Note 1.This is the bodyThis is the body of Note 1.This is the body of Note 1.This is the body of Note 1.This is the body of Note 1.This is the body o of Note 1.This is the body of Note 1.This is the body of Note 1."))
        // Thêm các note khác vào danh sách mẫu
        return sampleList
    }

    override fun onItemClick(note: Note) {
        val intent = Intent(this, UpdateNoteActivity::class.java)
        intent.putExtra("note_title", note.title)
        intent.putExtra("note_body", note.body)
        startActivity(intent)
    }
}
