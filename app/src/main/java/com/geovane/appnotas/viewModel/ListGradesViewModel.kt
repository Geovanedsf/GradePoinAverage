package com.geovane.appnotas.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.geovane.appnotas.view.ListGradesFragment
import com.geovane.appnotas.view.RegisterFragment

class ListGradesViewModel(val fragment: RegisterFragment): ViewModel() {

    fun calcularNota(nota1: Float, nota2: Float, nota3: Float, nota4: Float): Float {
        return ((nota1 + nota2) + (nota3 + nota4)) / 4
    }

    class ListGradesViewModelFactory(
        private val fragment: RegisterFragment
    ): ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return ListGradesViewModel(fragment) as T
        }
    }
}