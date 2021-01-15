package com.tfcporciuncula.hiltassistedinjection

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject

class OutputViewModel @AssistedInject constructor(
  upperCaseService: UpperCaseService,
  @Assisted input: String,
  @Assisted savedStateHandle: SavedStateHandle
) : ViewModel() {

  @AssistedFactory
  interface Factory {
    fun create(input: String, savedStateHandle: SavedStateHandle): OutputViewModel
  }

  init {
    if (savedStateHandle.get<String>("input") != input) throw RuntimeException("Crash")
  }

  private val outputLiveData = MutableLiveData(upperCaseService.run(input))

  fun outputLiveData(): LiveData<String> = outputLiveData
}
