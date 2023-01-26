package com.geovane.appnotas.resource

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.geovane.appnotas.R
import com.geovane.appnotas.model.DataCalculate
import com.geovane.appnotas.model.Student
import kotlinx.android.synthetic.main.item_notes.view.*

class ListGradesAdapter(
    private val listStudent: List<Student>,
    private val myList: List<DataCalculate>,
    private val onClicked: (Student) -> Unit,
    private val onEditClicked: (Student) -> Unit,
    private val onDeleteClicked: (Student) -> Unit) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

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
            holder.bind(listStudent[position], myList[position], onClicked, onEditClicked, onDeleteClicked)
            }
        }
    }

    override fun getItemCount(): Int {
        return myList.size
    }

    inner class ListGradesViewHolder constructor(
        itemView: View
    ) : RecyclerView.ViewHolder(itemView) {

        private val nameStudent = itemView.findViewById<TextView>(R.id.textViewNameStudent)
        private val resultStudent = itemView.findViewById<TextView>(R.id.textViewGrades)
        private val matterStudent = itemView.findViewById<TextView>(R.id.textViewMatterName)
        private val recyclerView = itemView.findViewById<RecyclerView>(R.id.recyclerView_best_notes)

        fun bind(student: Student,
                 dataCalculate: DataCalculate,
                 onClicked: (Student) -> Unit,
                 onEditClicked: (Student) -> Unit,
                 onDeleteClicked: (Student) -> Unit) {
            nameStudent.text = dataCalculate.name
            resultStudent.text = dataCalculate.result.toString()
            matterStudent.text = dataCalculate.subject


            itemView.setOnClickListener {
                onClicked(student)
            }

            itemView.imageButtonEdit.setOnClickListener {
                onEditClicked(student)
            }

            itemView.imageButtonDelete.setOnClickListener {
                onDeleteClicked(student)
            }


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