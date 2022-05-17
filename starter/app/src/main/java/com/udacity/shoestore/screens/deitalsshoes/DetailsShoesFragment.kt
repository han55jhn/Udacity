package com.udacity.shoestore.screens.deitalsshoes

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentDetailsShoesBinding
import com.udacity.shoestore.models.Shoe
import com.udacity.shoestore.screens.shoelist.ShoesListViewModel

class DetailsShoesFragment : Fragment() {

    private lateinit var binding: FragmentDetailsShoesBinding
    private val shoesListViewModel: ShoesListViewModel by activityViewModels()
    private val exampleOfShoe = Shoe("flat", 45.5, "LORO PIANA", "Comfortable")


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_details_shoes, container, false
        )

        navigateToShoesListScreen()
        binding.viewModel = shoesListViewModel
        binding.lifecycleOwner = this
        binding.infoOfShoe = exampleOfShoe

        triggerEvent()
        return binding.root
    }

    private fun navigateToShoesListScreen() {
        val toListShoes =
            DetailsShoesFragmentDirections.actionDetailsShoesFragmentToShoesListFragment()
        binding.cancelButton.setOnClickListener {
            resetDate()
            findNavController().navigate(toListShoes)
        }

    }


    private fun resetDate() {
        binding.editTextTextShoeName.text = null
        binding.editTextTextShoeCompany.text = null
        binding.editTextTextShoeSize.text = null
        binding.editTextDescription.text = null
    }

    private fun triggerEvent() {

        shoesListViewModel.eventNavigate.observe(viewLifecycleOwner, Observer { isFinished ->
            if (isFinished) {
                val action =
                    DetailsShoesFragmentDirections.actionDetailsShoesFragmentToShoesListFragment()
                findNavController().navigate(action)

                shoesListViewModel.doneFromNavigate()
            }

        })

    }
}