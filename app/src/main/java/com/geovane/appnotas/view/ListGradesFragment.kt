package com.geovane.appnotas.view

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.geovane.appnotas.R
import com.geovane.appnotas.model.BestNote
import com.geovane.appnotas.model.DataCalculate
import com.geovane.appnotas.resource.ListGradesAdapter
import kotlinx.android.synthetic.main.fragment_list_grades.*


class ListGradesFragment : Fragment(R.layout.fragment_list_grades) {

    private lateinit var listAdapter: ListGradesAdapter
    private val args: ListGradesFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initAdapter()
    }

    private fun initAdapter() {
        listAdapter = ListGradesAdapter(populaRecycler())

        recyclerView.apply {
            adapter = listAdapter
        }
    }

    private fun populaRecycler() : List<DataCalculate> {
        val dataCalculate = DataCalculate(args.dataCalculate.name, args.dataCalculate.result, args.dataCalculate.subject,
        MockBestNote.list)
        return listOf(dataCalculate)
    }

    object MockBestNote {
        private val bestNote1 = BestNote("Joao", "10")
        private val bestNote2 = BestNote("Zé", "9")
        private val bestNote3 = BestNote("Lukas", "7")
        var list = listOf(bestNote1, bestNote2, bestNote3)
    }
}