package edu.temple.desserrtapp

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class DessertViewModel {
    private val dessert: MutableLiveData<Item> by lazy {
        MutableLiveData<Item>()
    }

    fun getDessert(): LiveData<Item> {
        return dessert
    }

    fun setSelectedDessert(selectedDessert: Item){
        this.dessert.value = selectedDessert
    }
}