package com.geovane.appnotas.resource

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.geovane.appnotas.R
import com.geovane.appnotas.model.BestNote

class BestNotesAdapter : RecyclerView.Adapter<BestNotesAdapter.BestNotesViewHolder>() {

    var listBestNotes: List<BestNote> = emptyList()
    var clickBestNotes: (bestNote: BestNote) -> Unit = {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BestNotesViewHolder {
        return BestNotesViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_best_notes, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return listBestNotes.size
    }

    override fun onBindViewHolder(holder: BestNotesViewHolder, position: Int) {
        val bestNote = listBestNotes[position]
        holder.bind(bestNote)
    }

    class BestNotesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val textViewBestNote = itemView.findViewById<TextView>(R.id.textview_best_note)

        //o bind dentro do viewholder recebe o item da lista (nesse caso bestnotes)
        fun bind(bestNote: BestNote) {
            val concatenated = "${bestNote.name} - ${bestNote.note}"
            textViewBestNote.text = concatenated
        }

    }

}