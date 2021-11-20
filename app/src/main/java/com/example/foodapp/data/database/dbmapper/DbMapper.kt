package com.example.foodapp.data.database.dbmapper

import com.example.foodapp.data.database.model.FoodDbModel
import com.example.foodapp.domain.model.FoodModel

interface DbMapper {
  fun mapFoods(
    FoodDbModels: List<FoodDbModel>,
  ): List<FoodDbModel>

  fun mapFood(FoodDbModel: FoodDbModel): FoodDbModel
  fun mapDbFood(Food: FoodDbModel): FoodDbModel
}
