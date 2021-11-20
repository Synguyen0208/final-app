package com.example.foodapp.domain.model

import com.example.foodapp.R

const val NEW_Food_ID = -1L

/**
 * Model class that represents one Note
 */
data class FoodModel(
  val id: Long = NEW_Food_ID, // This value is used for new notes
  val name: String = "",
  val image: Int,
  val price: Long = 0,
  val star: Int,
)
