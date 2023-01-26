package com.geovane.appnotas.view

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import com.geovane.appnotas.R
import com.geovane.appnotas.model.BestNote
import com.geovane.appnotas.model.DataCalculate
import com.geovane.appnotas.model.Student
import com.geovane.appnotas.resource.ListGradesAdapter
import com.geovane.appnotas.viewmodel.ListGradesViewModel
import kotlinx.android.synthetic.main.fragment_list_grades.*


class ListGradesFragment : Fragment(R.layout.fragment_list_grades) {

    private lateinit var viewModel: ListGradesViewModel
    lateinit var listAdapter: ListGradesAdapter
    private val args: ListGradesFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setViewModel()
        initAdapter()
    }

    private fun initAdapter() {
        listAdapter = ListGradesAdapter(
            setProfileList(),
            setDataCalculateLis(),
            { cardClicked(it) },
            { editCard(it) },
            { deleteCard(it) }
        )

        recyclerView.apply {
            adapter = listAdapter
        }
    }

    fun setViewModel() {
        viewModel = ViewModelProvider(
            this,
            ListGradesViewModel.ListGradesViewModelFactory(args.student,this)
        )[ListGradesViewModel::class.java]
    }

    private fun populaRecycler() : List<DataCalculate> {
        val dataCalculate = DataCalculate(
            args.dataCalculate.name,
            args.dataCalculate.result,
            args.dataCalculate.subject,
            MockBestNote.list)
        return listOf(dataCalculate)
    }

    fun setProfileList() : List<Student> {
        var list = ArrayList<Student>()
        list.add(args.student)
        return list
    }

    fun setDataCalculateLis() : List<DataCalculate> {
        var list = ArrayList<DataCalculate>()
        list.add(args.dataCalculate)
        return list
    }

    private fun cardClicked(student: Student) {
        println("Clicou no card do estudante: $student")
    }

    private fun editCard(student: Student) {
        println("Editar o estudante: $student")
    }

    private fun deleteCard(student: Student) {
        println("Deletar o estudante: $student")
    }


    object MockBestNote {
        private val bestNote1 = BestNote("Geovane", "10")
        private val bestNote2 = BestNote("Pablo", "9")
        private val bestNote3 = BestNote("Ricardo", "7")
        var list = listOf(bestNote1, bestNote2, bestNote3)
    }
}