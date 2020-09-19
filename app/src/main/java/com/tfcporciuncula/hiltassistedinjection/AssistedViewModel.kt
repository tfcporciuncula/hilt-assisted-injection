@file:Suppress("UNCHECKED_CAST")

package com.tfcporciuncula.hiltassistedinjection

import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

inline fun <reified T : ViewModel> Fragment.assistedViewModel(
  crossinline viewModelProducer: () -> T
) = viewModels<T> {
  object : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>) = viewModelProducer() as T
  }
}
