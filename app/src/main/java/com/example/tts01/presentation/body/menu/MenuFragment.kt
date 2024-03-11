package com.example.tts01.presentation.body.menu

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.tts01.R
import com.example.tts01.databinding.FragmentMenuBinding
import com.example.tts01.presentation.VickVM
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MenuFragment : Fragment() {
    private var _binding: FragmentMenuBinding? = null
    private val binding get() = _binding!!
    private val viewmodel:VickVM by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMenuBinding.inflate(layoutInflater, container, false)
        binding.btn3.setOnClickListener {
            viewmodel.setTitle("BREAK")
            viewmodel.setSubtitle("On break")
            findNavController().navigate(R.id.action_menuFragment_to_simpleDialogFragment)
        }
        binding.btn4.setOnClickListener {
            viewmodel.setTitle("MEETING")
            viewmodel.setSubtitle("In meeting")
            findNavController().navigate(R.id.action_menuFragment_to_simpleDialogFragment)
        }
        binding.btn5.setOnClickListener {
            viewmodel.setTitle("CLEANING")
            viewmodel.setSubtitle("Cleaning")
            findNavController().navigate(R.id.action_menuFragment_to_simpleDialogFragment)
        }
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}