package com.geovane.appnotas.viewmodel

import android.content.Context
import android.content.SharedPreferences
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.geovane.appnotas.model.Student
import com.geovane.appnotas.view.ListGradesFragment

class ListGradesViewModel(private val student: Student,
                          private val fragment: ListGradesFragment): ViewModel() {

    private var list = mutableListOf<Student>()


    fun updateStudent(student: Student, studentUpdated: Student) {
        list.remove(student)
        list.add(student)
    }

    fun deleteStudent(student: Student) {
        list.remove(student)
        fragment.listAdapter.notifyItemRemoved(list.size)
    }

    private fun myPerfs(): SharedPreferences {
        return fragment.requireContext().getSharedPreferences("PREFERENCE_NAME", Context.MODE_PRIVATE)
    }

    fun onSaveStudentData() {
//        val json = Gson().toJson(student)
//
//        myPrefs().edit {
//            putString("initialStudent", json)
//            commit()
//        }
    }

    class ListGradesViewModelFactory(
        private val student: Student,
        private val fragment: ListGradesFragment
    ): ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return ListGradesViewModel(student, fragment) as T
        }
    }
}