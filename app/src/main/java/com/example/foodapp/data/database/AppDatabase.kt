package com.example.foodapp.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.foodapp.data.database.dao.FoodDao
import com.example.foodapp.data.database.model.FoodDbModel

/**
 * App's database.
 *
 * It contains two tables: Note table and Color table.
 */
@Database(entities = [FoodDbModel::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

  companion object {
    const val DATABASE_NAME = "food-database"
  }

  abstract fun foodDao(): FoodDao
}
