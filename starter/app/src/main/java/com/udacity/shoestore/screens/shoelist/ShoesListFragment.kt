package com.udacity.shoestore.screens.shoelist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentShoesListBinding
import com.udacity.shoestore.databinding.ItemShoesBinding

class ShoesListFragment : Fragment() {

    private lateinit var binding: FragmentShoesListBinding
    private val shoesListViewModel: ShoesListViewModel by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_shoes_list, container, false
        )

        addShoesItem()

        navigateToDetailsScreen()

        return binding.root
    }


    private fun navigateToDetailsScreen() {

        binding.addFloatingButton.setOnClickListener {

            val toDetails =
                ShoesListFragmentDirections.actionShoesListFragmentToDetailsShoesFragment()

            findNavController().navigate(toDetails)


        }
    }

    private fun addShoesItem() {
        shoesListViewModel.shoes.observe(viewLifecycleOwner) { listOfShoes ->
            listOfShoes.forEach {
                val shoesItem = ItemShoesBinding.inflate(layoutInflater)
                shoesItem.shoeDetails = it
                binding.shoesItemLayout.addView(shoesItem.root)
            }

        }


    }
}