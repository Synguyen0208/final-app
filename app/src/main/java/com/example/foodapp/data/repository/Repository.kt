package com.example.foodapp.data.repository

import androidx.lifecycle.LiveData
import com.example.foodapp.data.database.model.FoodDbModel
import com.example.foodapp.domain.model.FoodModel

/**
 * Allows communication with the app's database.
 */
interface Repository {

  fun getAllFoods(): LiveData<List<FoodDbModel>>

  fun getFood(id: Long): LiveData<FoodDbModel>
  fun insertFood(food: FoodDbModel)

  fun deleteFood(id: Long)

  fun deleteFoods(foodIds: List<Long>)
}
