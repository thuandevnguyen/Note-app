import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myappnote.Note
import com.example.myappnote.R

class NoteAdapter(private val noteList: List<Note>) : RecyclerView.Adapter<NoteAdapter.NoteViewHolder>() {

    class NoteViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textViewNoteTitle: TextView = itemView.findViewById(R.id.textViewNoteTitle)
        val textViewNoteBody: TextView = itemView.findViewById(R.id.textViewNoteBody)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.itemnote, parent, false)
        return NoteViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        val currentNote = noteList[position]
        holder.textViewNoteTitle.text = currentNote.title
        holder.textViewNoteBody.text = currentNote.body
    }

    override fun getItemCount(): Int {
        return noteList.size
    }
}
