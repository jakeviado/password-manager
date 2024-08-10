package com.tick.secure.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.tick.secure.R
import com.tick.secure.databinding.FragmentLandingPageBinding

class LandingPage : Fragment() {

    private var _binding: FragmentLandingPageBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLandingPageBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.loginButton.setOnClickListener {
            findNavController().navigate(R.id.action_landingPage_to_login_page)
        }

        binding.registerButton.setOnClickListener {
            findNavController().navigate(R.id.action_landingPage_to_registration_page)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}