package com.geovane.appnotas.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.geovane.appnotas.R
import kotlinx.android.synthetic.main.fragment_list_grades.*


class ListGradesFragment : Fragment(R.layout.fragment_list_grades) {

    val args: ListGradesFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        println("<<<<<<<<<<")
        println(args)
        println("<<<<<<<<<<")
//        setButtonClicked()
//    }
//
//    fun setButtonClicked() {
//        but.setOnClickListener {
//        // do NOTHING
//        }
//    }
    }
}