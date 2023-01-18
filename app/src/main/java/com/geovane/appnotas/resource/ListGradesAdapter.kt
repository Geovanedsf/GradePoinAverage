package com.geovane.appnotas.resource

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.geovane.appnotas.R
import com.geovane.appnotas.model.Grades
import com.geovane.appnotas.model.Student
import kotlinx.android.synthetic.main.res_list_grades.view.*

class ListGradesAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private lateinit var listStudents: List<Student>

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return ListGradesViewHolder(
            LayoutInflater.from(
                parent.context
            ).inflate(
                R.layout.res_list_grades, parent, false)
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(holder) {
            is ListGradesViewHolder -> {
            holder.bind(listStudents[position])
            }
        }
    }

    override fun getItemCount(): Int {
        return listStudents.size
    }

    fun setDataSet(list: List<Student>) {
        listStudents = list
    }


    class ListGradesViewHolder constructor(
        itemView: View
    ) : RecyclerView.ViewHolder(itemView) {
        fun bind(student: Student) {
            var nameStudent = itemView.textViewNameStudent
            var matterStudent = itemView.textViewMatterName


            nameStudent.text = student.name
            matterStudent.text = student.grades.subject
        }
    }
}