package com.udacity.shoestore.screens.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentLoginBinding


class LoginFragment : Fragment() {

    private lateinit var binding: FragmentLoginBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_login, container, false
        )
        setHasOptionsMenu(true)
        navigateToWelcomeScreen()
        return binding.root
    }

    private fun navigateToWelcomeScreen() {

        binding.loginButton.setOnClickListener {
            val toWelcome = LoginFragmentDirections.actionLoginFragmentToWelcomeFragment(
                binding.emailEditText.text.toString()
            )
            findNavController().navigate(toWelcome)
        }
    }

    //I add this to hide the back Button in this fragment only
    override fun onPrepareOptionsMenu(menu: Menu) {
        val hideItem = menu.findItem(R.id.loginFragment)
        hideItem.isVisible = false
    }

}