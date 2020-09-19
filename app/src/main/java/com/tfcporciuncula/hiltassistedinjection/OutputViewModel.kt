package com.tfcporciuncula.hiltassistedinjection

import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel

class OutputViewModel @ViewModelInject constructor(
  upperCaseService: UpperCaseService,
  @Assisted savedStateHandle: SavedStateHandle
) : ViewModel() {

  private val outputLiveData = MutableLiveData<String>()

  fun outputLiveData(): LiveData<String> = outputLiveData

  init {
    val input = savedStateHandle.get<String>("input")!!
    outputLiveData.value = upperCaseService.run(input)
  }
}
