package com.example.awbw.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.awbw.R
import com.example.awbw.databinding.Test1FragmentBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class Test1Fragment : Fragment() {

    private lateinit var binding: Test1FragmentBinding

    companion object {
        fun newInstance() = Test1Fragment()
    }
    private lateinit var viewModel: Test1ViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = Test1FragmentBinding.inflate(layoutInflater)
        viewModel = ViewModelProvider(this).get(Test1ViewModel::class.java)
        viewModel.effect.observe(viewLifecycleOwner) {
            when (it) {
                is Test1Effect.GoToSuccessScreen -> findNavController().navigate(
                    Test1FragmentDirections.actionTest1FragmentToCorrectAction(
                        requireContext().getString(
                            R.string.test_1
                        ),
                        requireContext().getString(R.string.thisViewShouldAppear)
                    )
                )
                else -> Unit
            }
        }
        binding.confirmationInput.addTextChangedListener {
            viewModel.setConfirmation(it?.toString())
        }
        binding.confirmButton.setOnClickListener {
            viewModel.confirmButtonCLicked()
        }
        return binding.root
    }
}
