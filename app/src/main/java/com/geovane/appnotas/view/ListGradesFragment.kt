package com.geovane.appnotas.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.geovane.appnotas.R
import com.geovane.appnotas.resource.DataSourceGrades
import com.geovane.appnotas.resource.ListGradesAdapter
import kotlinx.android.synthetic.main.fragment_list_grades.*


class ListGradesFragment : Fragment(R.layout.fragment_list_grades) {

    private lateinit var listAdapter: ListGradesAdapter
    val args: ListGradesFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initAdapter()
//        populaRecycler()


//        println("<<<<<<<<<<")
//        println(args)
//        println("<<<<<<<<<<")
    }

    private fun initAdapter() {
        listAdapter = ListGradesAdapter()

        recyclerView.apply {
            adapter = adapter
            layoutManager = LinearLayoutManager(requireContext())
        }
    }

//    private fun populaRecycler() {
//        DataSourceGrades.createGrades(args.grades)
//
//        )
//    }
}