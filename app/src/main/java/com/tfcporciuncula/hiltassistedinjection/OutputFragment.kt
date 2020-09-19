package com.tfcporciuncula.hiltassistedinjection

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.tfcporciuncula.hiltassistedinjection.databinding.FragmentOutputBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class OutputFragment : Fragment(R.layout.fragment_output) {

  private val viewModel by viewModels<OutputViewModel>()

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    val binding = FragmentOutputBinding.bind(view)
    viewModel.outputLiveData().observe(viewLifecycleOwner, binding.outputTextView::setText)
  }
}
