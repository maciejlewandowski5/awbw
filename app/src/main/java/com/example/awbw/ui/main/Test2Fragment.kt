package com.example.awbw.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.awbw.R
import com.example.awbw.databinding.Test2FragmentBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class Test2Fragment : Fragment() {

    private lateinit var binding: Test2FragmentBinding

    companion object {
        fun newInstance() = Test2Fragment()
    }
    private lateinit var viewModel: Test2ViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = Test2FragmentBinding.inflate(layoutInflater)
        viewModel = ViewModelProvider(this).get(Test2ViewModel::class.java)

        viewModel.effect.observe(viewLifecycleOwner) {
            when (it) {
                is Test2Effect.GoToSuccessScreen -> findNavController().navigate(
                    Test2FragmentDirections.actionTest2FragmentToCorrectAction(
                        requireContext().getString(R.string.test_2),
                        requireContext().getString(R.string.thisViewShouldAppear)
                    )
                )
                else -> Unit
            }
        }
        setWrongButtonsListeners()
        binding.correct.setOnClickListener { viewModel.correctButtonClicked() }
        return binding.root
    }

    private fun setWrongButtonsListeners() {
        binding.wrong1Button.setOnClickListener { viewModel.wrongButtonClicked() }
        binding.wrong2Button.setOnClickListener { viewModel.wrongButtonClicked() }
        binding.wrong3Button.setOnClickListener { viewModel.wrongButtonClicked() }
        binding.wrong4Button.setOnClickListener { viewModel.wrongButtonClicked() }
        binding.wrong5Button.setOnClickListener { viewModel.wrongButtonClicked() }
        binding.wrong6Button.setOnClickListener { viewModel.wrongButtonClicked() }
        binding.wrong7Button.setOnClickListener { viewModel.wrongButtonClicked() }
        binding.wrong8Button.setOnClickListener { viewModel.wrongButtonClicked() }
        binding.wrong9Button.setOnClickListener { viewModel.wrongButtonClicked() }
        binding.wrong10Button.setOnClickListener { viewModel.wrongButtonClicked() }
        binding.wrong11Button.setOnClickListener { viewModel.wrongButtonClicked() }
        binding.wrong12Button.setOnClickListener { viewModel.wrongButtonClicked() }
    }
}
