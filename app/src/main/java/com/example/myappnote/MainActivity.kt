package com.example.myappnote

import NoteAdapter
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {

    private val noteList: MutableList<Note> = mutableListOf() // Danh sách các ghi chú

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // ...
        val addNoteButton = findViewById<FloatingActionButton>(R.id.floatingActionAdd)
        addNoteButton.setOnClickListener {
            val intent = Intent(this, NewNoteActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.search_note, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.menu_search -> {
                // TODO: Xử lý khi mục "Search" được chọn
                true
            }
            R.id.menu_new_note -> {
                // Xử lý khi mục "New Note" được chọn
                openSaveNoteActivity()
                true
            }
            R.id.menu_delete -> {
                // TODO: Xử lý khi mục "Delete Note" được chọn
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    // Phương thức mở SaveNoteActivity để tạo ghi chú mới
    private fun openSaveNoteActivity() {
        val intent = Intent(this, NewNoteActivity::class.java)
        startActivityForResult(intent, SAVE_NOTE_REQUEST)
    }

    // Phương thức nhận dữ liệu trả về từ Activity con (SaveNoteActivity)
    @Deprecated("Deprecated in Java")
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == SAVE_NOTE_REQUEST && resultCode == RESULT_OK) {
            val noteTitle = data?.getStringExtra("noteTitle")
            val noteBody = data?.getStringExtra("noteBody")

            if (!noteTitle.isNullOrEmpty() && !noteBody.isNullOrEmpty()) {
                val note = Note(noteTitle, noteBody)
                noteList.add(note)
                displayNotes()
            }
        }
    }

    private fun displayNotes() {
        val recyclerViewNotes: RecyclerView = findViewById(R.id.recyclerViewNotes)
        val noteAdapter = NoteAdapter(noteList)
        recyclerViewNotes.adapter = noteAdapter
        recyclerViewNotes.layoutManager = LinearLayoutManager(this)
    }

    companion object {
        private const val SAVE_NOTE_REQUEST = 1
    }
}
