package com.tfcporciuncula.hiltassistedinjection

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import javax.inject.Inject

class OutputViewModel @ViewModelInject constructor(
  upperCaseService: UpperCaseService,
  input: String
) : ViewModel() {

  class Factory @Inject constructor(private val upperCaseService: UpperCaseService) {
    fun create(input: String) = OutputViewModel(upperCaseService, input)
  }

  private val outputLiveData = MutableLiveData(upperCaseService.run(input))

  fun outputLiveData(): LiveData<String> = outputLiveData
}
