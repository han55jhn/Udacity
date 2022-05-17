package com.udacity.shoestore.screens.shoelist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe

class ShoesListViewModel : ViewModel() {

    private val _shoes = MutableLiveData<MutableList<Shoe>>()
    val shoes: LiveData<MutableList<Shoe>>
        get() = _shoes

    private val _eventNavigate = MutableLiveData<Boolean>()
    val eventNavigate: LiveData<Boolean>
        get() = _eventNavigate


    init {

        _shoes.value = mutableListOf()

    }


    fun pressSaveButton(
        nameOfShoe: String,
        sizeOfShoe: String,
        companyOfShoe: String,
        descriptionOfShoe: String
    ) {
        _eventNavigate.value = true
        _shoes.value?.add(Shoe(nameOfShoe, sizeOfShoe.toDouble(), companyOfShoe, descriptionOfShoe))

    }

    fun doneFromNavigate() {
        _eventNavigate.value = false
    }
}