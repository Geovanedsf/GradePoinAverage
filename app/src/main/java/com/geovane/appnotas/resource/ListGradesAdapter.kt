package com.geovane.appnotas.resource

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.geovane.appnotas.R
import com.geovane.appnotas.model.DataCalculate
import com.geovane.appnotas.model.Grades
import com.geovane.appnotas.model.Student
import kotlinx.android.synthetic.main.res_list_grades.view.*

class ListGradesAdapter(private val myList: List<DataCalculate>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

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
        private val nameStudent = itemView.textViewNameStudent
        private val resultStudent = itemView.textViewGrades
        private val matterStudent = itemView.textViewMatterName

        fun bind(dataCalculate: DataCalculate) {
            nameStudent.text = dataCalculate.name
            resultStudent.text = dataCalculate.result.toString()
            matterStudent.text = dataCalculate.subject
        }
    }
}