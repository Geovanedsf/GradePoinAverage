package com.geovane.appnotas.resource

import com.geovane.appnotas.model.Student

class DataSourceGrades {

    companion object {
        fun createGrades(student: Student, callback: (list: ArrayList<Student>) -> Unit) {
            val list = ArrayList<Student>()
            list.add(student)
            callback(list)

            // DO NOTHING
        }
    }
}