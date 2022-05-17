package com.udacity.shoestore.screens.welcome

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentWelcomeBinding


class WelcomeFragment : Fragment() {

    private lateinit var binding: FragmentWelcomeBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_welcome, container, false
        )
        getEmailUser()
        navigateToInstructionScreen()

        return binding.root
    }

    private fun navigateToInstructionScreen() {
        binding.welcomeButton.setOnClickListener {
            val toInstruction =
                WelcomeFragmentDirections.actionWelcomeFragmentToInstructionFragment()
            findNavController().navigate(toInstruction)
        }
    }

    private fun getEmailUser() {
        val email = WelcomeFragmentArgs.fromBundle(requireArguments()).userEmail
        binding.emailUser.text = email


    }


}