package com.example.foodapp.data.database.dbmapper

import com.example.foodapp.data.database.model.FoodDbModel
import com.example.foodapp.domain.model.FoodModel
import com.example.foodapp.domain.model.NEW_Food_ID

class DbMapperImpl : DbMapper {

  override fun mapFoods(
    FoodDbModels: List<FoodDbModel>,
  ): List<FoodDbModel> = FoodDbModels.map {

    mapFood(it)
  }

  override fun mapFood(FoodDbModel: FoodDbModel): FoodDbModel {
    return with(FoodDbModel) { FoodDbModel(id, name, image, price, star) }
  }

  override fun mapDbFood(note: FoodDbModel): FoodDbModel =
    with(note) {
      if (id == NEW_Food_ID)
        FoodDbModel(
          name = name,
          image = image,
          price = price,
          star = star,
        )
      else
        FoodDbModel(id, name, image, price, star)
    }

}
