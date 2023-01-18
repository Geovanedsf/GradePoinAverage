package com.geovane.appnotas.resource

import com.geovane.appnotas.model.Student
import javax.security.auth.callback.Callback

class DataSourceGrades {

    companion object {
        fun createGrades(student: Student, callback: (list: ArrayList<Student>) -> Unit) {
            var list = ArrayList<Student>()
            list.add(student)
            callback(list)
        }
    }
}