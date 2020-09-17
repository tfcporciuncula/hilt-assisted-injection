package com.tfcporciuncula.hiltassistedinjection

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class OutputViewModel @ViewModelInject constructor(
  private val upperCaseService: UpperCaseService
) : ViewModel() {

  private val outputLiveData = MutableLiveData<String>()

  fun outputLiveData(): LiveData<String> = outputLiveData

  fun setInput(input: String) {
    outputLiveData.value = upperCaseService.run(input)
  }
}
