package com.example.foodapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.foodapp.data.database.model.FoodDbModel
import com.example.foodapp.data.repository.Repository
import com.example.foodapp.domain.model.FoodModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

/**
 * View model used for storing the global app state.
 *
 * This view model is used for all screens.
 */
class MainViewModel(private val repository: Repository) : ViewModel() {


    val foods : LiveData<List<FoodDbModel>> by lazy {
        repository.getAllFoods()
    }
    fun onNoteCheckedChange(food:FoodDbModel){
        viewModelScope.launch(Dispatchers.Default){
            repository.insertFood(food)
        }
    }
}
