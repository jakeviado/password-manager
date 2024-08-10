package com.tick.secure.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import com.tick.secure.R
import com.tick.secure.viewmodel.RegistrationViewModel

class RegistrationPage : Fragment() {

    private val viewModel: RegistrationViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_registration_page, container, false)

        val usernameEditText = view.findViewById<EditText>(R.id.registration_edit_username)
        val passwordEditText = view.findViewById<EditText>(R.id.registration_edit_password)
        val confirmPasswordEditText = view.findViewById<EditText>(R.id.editTextConfirmPassword)
        val registerButton = view.findViewById<Button>(R.id.registration_page_next_btn)

        registerButton.setOnClickListener {
            val username = usernameEditText.text.toString()
            val password = passwordEditText.text.toString()
            val confirmPassword = confirmPasswordEditText.text.toString()

            viewModel.registerUser(username, password, confirmPassword)
        }

        viewModel.registrationResult.observe(viewLifecycleOwner) { success ->
            if (success) {
                Toast.makeText(context, "Registration successful", Toast.LENGTH_SHORT).show()
                view.findNavController().navigate(R.id.action_registration_page_to_login_page)
            } else {
                Toast.makeText(context, "Registration failed", Toast.LENGTH_SHORT).show()
            }
        }

        return view
    }
}