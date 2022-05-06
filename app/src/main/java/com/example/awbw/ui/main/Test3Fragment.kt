package com.example.awbw.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.awbw.R
import com.example.awbw.databinding.Test3FragmentBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class Test3Fragment : Fragment() {
    private lateinit var binding: Test3FragmentBinding

    companion object {
        fun newInstance() = Test3Fragment()
    }

    private lateinit var viewModel: Test3ViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = Test3FragmentBinding.inflate(layoutInflater)
        viewModel = ViewModelProvider(this).get(Test3ViewModel::class.java)

        viewModel.effect.observe(viewLifecycleOwner) {
            when (it) {
                is Test3Effect.GoToSuccessScreen -> findNavController().navigate(
                    Test3FragmentDirections.actionTest3FragmentToCorrectAction(
                        requireContext().getString(
                            R.string.test_3
                        ),
                        requireContext().getString(R.string.youLoggedIn)
                    )
                )
                is Test3Effect.IncorrectCredentials -> binding.errorMessage.visibility = VISIBLE
                else -> Unit
            }
        }
        binding.emailInput.addTextChangedListener {
            hideError()
            viewModel.setEmail(it?.toString())
        }
        binding.passwordInput.addTextChangedListener {
            hideError()
            viewModel.setPassword(it?.toString())
        }
        binding.checkBox.setOnCheckedChangeListener { _, isChecked ->
            hideError()
            viewModel.setAgreed(isChecked)
        }
        binding.confirmButton.setOnClickListener {
            viewModel.login()
        }
        return binding.root
    }

    private fun hideError() {
        binding.errorMessage.visibility = GONE
    }
}
