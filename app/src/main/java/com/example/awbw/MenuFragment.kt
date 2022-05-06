package com.example.awbw

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.awbw.databinding.ManuFragmentBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MenuFragment : Fragment() {

    private lateinit var binding: ManuFragmentBinding

    companion object {
        fun newInstance() = MenuFragment()
    }

    private lateinit var viewModel: MenuViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = ManuFragmentBinding.inflate(layoutInflater)
        viewModel = ViewModelProvider(this).get(MenuViewModel::class.java)

        binding.test1Button.setOnClickListener { findNavController().navigate(MenuFragmentDirections.actionMenuToTest1Fragment()) }
        binding.test2Button.setOnClickListener { findNavController().navigate(MenuFragmentDirections.actionMenuToTest2Fragment()) }
        binding.test3Button.setOnClickListener { findNavController().navigate(MenuFragmentDirections.actionMenuToTest3Fragment()) }
        return binding.root
    }
}
