package com.tfcporciuncula.hiltassistedinjection

import java.util.Locale
import javax.inject.Inject

class UpperCaseService @Inject constructor() {

  fun run(input: String) = input.toUpperCase(Locale.getDefault())
}
