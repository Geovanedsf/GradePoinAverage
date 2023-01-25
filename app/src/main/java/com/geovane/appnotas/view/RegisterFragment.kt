package com.geovane.appnotas.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.geovane.appnotas.R
import com.geovane.appnotas.model.DataCalculate
import com.geovane.appnotas.model.Grades
import com.geovane.appnotas.model.Student
import com.geovane.appnotas.viewmodel.RegisterViewModel
import kotlinx.android.synthetic.main.fragment_register.*


class RegisterFragment : Fragment(R.layout.fragment_register) {

    private lateinit var viewModel: RegisterViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setButtonClicked()
        setViewModel()
    }

    fun setButtonClicked() {
        buttonCalculateRegister.setOnClickListener {
            calculateGrades()
        }
    }

    fun setViewModel() {
        viewModel = ViewModelProvider(
            this,
            RegisterViewModel.RegisterViewModelFactory(this)
        )[RegisterViewModel::class.java]
    }

    fun calculateGrades() {
        val student = Student(
            editTextRegisterName.text.toString(),
            Grades(
                editTextRegisterMatter.text.toString(),
                editTextNoteOne.text.toString().toFloat(),
                editTextNoteTwo.text.toString().toFloat(),
                editTextNoteThree.text.toString().toFloat(),
                editTextNoteFour.text.toString().toFloat(),
            )
        )
        val dataCalculate = DataCalculate(
            student.name, viewModel.calcularNota(
                student.grades.noteOne,
                student.grades.noteTwo,
                student.grades.noteThree,
                student.grades.noteFour
            ), student.grades.subject, emptyList()
        )
        var action = RegisterFragmentDirections.actionRegisterFragmentToListGradesFragment(
            dataCalculate,
            student
        )
        findNavController().navigate(action)
    }
}