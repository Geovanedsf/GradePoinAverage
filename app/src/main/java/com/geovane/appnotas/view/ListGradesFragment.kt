package com.geovane.appnotas.view

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import com.geovane.appnotas.R
import com.geovane.appnotas.model.BestNote
import com.geovane.appnotas.model.DataCalculate
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
        listAdapter = ListGradesAdapter(populaRecycler())

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

    object MockBestNote {
        private val bestNote1 = BestNote("Geovane", "10")
        private val bestNote2 = BestNote("Pablo", "9")
        private val bestNote3 = BestNote("Ricardo", "7")
        var list = listOf(bestNote1, bestNote2, bestNote3)
    }
}