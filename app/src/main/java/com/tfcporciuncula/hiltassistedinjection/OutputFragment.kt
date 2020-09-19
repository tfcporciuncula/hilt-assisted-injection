package com.tfcporciuncula.hiltassistedinjection

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import com.tfcporciuncula.hiltassistedinjection.databinding.FragmentOutputBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class OutputFragment : Fragment(R.layout.fragment_output) {

  private val args by navArgs<OutputFragmentArgs>()

  @Inject lateinit var viewModelFactory: OutputViewModel.Factory

  private val viewModel by viewModels<OutputViewModel> {
    object : ViewModelProvider.Factory {
      override fun <T : ViewModel?> create(modelClass: Class<T>) = viewModelFactory.create(args.input) as T
    }
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    val binding = FragmentOutputBinding.bind(view)
    viewModel.outputLiveData().observe(viewLifecycleOwner, binding.outputTextView::setText)
  }
}
