package com.tfcporciuncula.hiltassistedinjection

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.tfcporciuncula.hiltassistedinjection.InputFragmentDirections.Companion.toOutput
import com.tfcporciuncula.hiltassistedinjection.databinding.FragmentInputBinding

class InputFragment : Fragment(R.layout.fragment_input) {

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    val binding = FragmentInputBinding.bind(view)
    binding.submitButton.setOnClickListener {
      val input = binding.inputEditText.text.toString()
      findNavController().navigate(toOutput(input))
    }
  }
}
