package com.geovane.appnotas.resource

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.geovane.appnotas.R
import com.geovane.appnotas.model.DataCalculate
class ListGradesAdapter(private val myList: List<DataCalculate>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return ListGradesViewHolder(
            LayoutInflater.from(
                parent.context
            ).inflate(
                R.layout.item_notes, parent, false)
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(holder) {
            is ListGradesViewHolder -> {
            holder.bind(myList[position])
            }
        }
    }

    override fun getItemCount(): Int {
        return myList.size
    }

    class ListGradesViewHolder constructor(
        itemView: View
    ) : RecyclerView.ViewHolder(itemView) {

        private val nameStudent = itemView.findViewById<TextView>(R.id.textViewNameStudent)
        private val resultStudent = itemView.findViewById<TextView>(R.id.textViewGrades)
        private val matterStudent = itemView.findViewById<TextView>(R.id.textViewMatterName)
        private val recyclerView = itemView.findViewById<RecyclerView>(R.id.recyclerView_best_notes)

        fun bind(dataCalculate: DataCalculate) {
            nameStudent.text = dataCalculate.name
            resultStudent.text = dataCalculate.result.toString()
            matterStudent.text = dataCalculate.subject

            BestNotesAdapter().apply {
                this.listBestNotes = dataCalculate.bestNotes
                this.clickBestNotes = { bestNote ->
                    Toast.makeText(itemView.context, bestNote.name, Toast.LENGTH_LONG).show()
                }
                recyclerView.adapter = this
            }
        }
    }
}