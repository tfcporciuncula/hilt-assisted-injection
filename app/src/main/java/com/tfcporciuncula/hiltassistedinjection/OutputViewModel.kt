package com.tfcporciuncula.hiltassistedinjection

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.squareup.inject.assisted.Assisted
import com.squareup.inject.assisted.AssistedInject

class OutputViewModel @AssistedInject constructor(
  upperCaseService: UpperCaseService,
  @Assisted input: String
) : ViewModel() {

  @AssistedInject.Factory
  interface Factory {
    fun create(input: String): OutputViewModel
  }

  private val outputLiveData = MutableLiveData(upperCaseService.run(input))

  fun outputLiveData(): LiveData<String> = outputLiveData
}
