package com.example.tts01.presentation.body.simpledialog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.tts01.databinding.FragmentSimpleDialogBinding
import com.example.tts01.presentation.VickVM

class SimpleDialogFragment : Fragment() {
    private var _binding: FragmentSimpleDialogBinding? = null
    private val binding get() = _binding!!
    private val viewmodel:VickVM by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSimpleDialogBinding.inflate(layoutInflater, container, false)
        viewmodel.subTitle.observe(viewLifecycleOwner){
            binding.subtitle.text = it
        }
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}