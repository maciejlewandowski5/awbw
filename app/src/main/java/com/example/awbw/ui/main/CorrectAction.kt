package com.example.awbw.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.awbw.databinding.CorrectActionFragmentBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CorrectAction : Fragment() {
    private lateinit var binding: CorrectActionFragmentBinding

    companion object {
        fun newInstance() = CorrectAction()
    }

    private lateinit var viewModel: CorrectActionViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = CorrectActionFragmentBinding.inflate(layoutInflater)
        val args: CorrectActionArgs by navArgs()
        binding.testTitle.text = args.screenTitle
        binding.confirmationText.text = args.message
        binding.backToStart.setOnClickListener {
            findNavController().navigate(
                CorrectActionDirections.actionCorrectActionToMenu()
            )
        }
        return binding.root
    }
}
