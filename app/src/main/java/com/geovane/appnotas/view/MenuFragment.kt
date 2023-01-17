package com.geovane.appnotas.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.geovane.appnotas.R
import kotlinx.android.synthetic.main.fragment_menu.*

class MenuFragment : Fragment(R.layout.fragment_menu) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setButtonClicked()

    }

    fun setButtonClicked() {
        buttonRegister.setOnClickListener {
            findNavController().navigate(R.id.action_menuFragment_to_registerFragment)
        }
    }
}