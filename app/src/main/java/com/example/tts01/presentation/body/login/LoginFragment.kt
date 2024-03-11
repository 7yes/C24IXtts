package com.example.tts01.presentation.body.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.tts01.R
import com.example.tts01.databinding.FragmentLoginBinding
import com.example.tts01.presentation.VickVM
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginFragment : Fragment() {
    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!
    private val viewmodel: VickVM by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLoginBinding.inflate(layoutInflater, container, false)
        binding.etLogin.setOnEditorActionListener { v, actionId, event ->
            if(viewmodel.logIn(binding.etLogin.text.toString())) gotoMenu()
            false
        }
        return binding.root
    }

    private fun gotoMenu() {
        findNavController().navigate(R.id.action_loginFragment_to_menuFragment4)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}