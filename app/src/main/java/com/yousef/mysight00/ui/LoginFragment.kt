package com.yousef.mysight00.ui

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.yousef.mysight00.R
import com.yousef.mysight00.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {

    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val navController = findNavController()

        binding.btnSignupLog.setOnClickListener {
            navController.navigate(R.id.action_loginFragment_to_registerCompFragment)
        }

        binding.tvForgetPassLogin.setOnClickListener {
            navController.navigate(R.id.action_loginFragment_to_forgetPassFragment)
        }

        binding.btnLoginLogin.setOnClickListener {
            val email = binding.emailLogin.text.toString().trim()
            val password = binding.passwordLogin.text.toString().trim()

            when {
                email == "companion@gmail.com" && password == "123456" -> {
                    navController.navigate(R.id.action_loginFragment_to_homeCompanionFragment)
                }
                email == "alzhaimer@gmail.com" && password == "123456" -> {
                    navController.navigate(R.id.action_loginFragment_to_homeAlzheimerFragment)
                }
                email == "blind@gmail.com" && password == "123456" -> {
                    navController.navigate(R.id.action_loginFragment_to_homeBlindFragment)
                }
                else -> {
                    val toast = Toast.makeText(requireContext(), "Invalid email or password", Toast.LENGTH_SHORT)
                    val view = toast.view

                    view?.background = ContextCompat.getDrawable(requireContext(), R.drawable.toast_background)

                    val text = view?.findViewById<TextView>(android.R.id.message)
                    text?.setTextColor(Color.BLACK)

                    toast.show()

                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
