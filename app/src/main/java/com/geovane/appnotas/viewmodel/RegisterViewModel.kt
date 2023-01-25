package com.geovane.appnotas.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.geovane.appnotas.view.RegisterFragment

class RegisterViewModel (private val fragment: RegisterFragment): ViewModel() {

    fun calcularNota(nota1: Float, nota2: Float, nota3: Float, nota4: Float): Float {
        val result = (nota1 + nota2 + nota3 + nota4) / 4
        return result
    }

    class RegisterViewModelFactory(
        private val fragment: RegisterFragment
    ) :  ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return RegisterViewModel(fragment) as T
        }
    }
}