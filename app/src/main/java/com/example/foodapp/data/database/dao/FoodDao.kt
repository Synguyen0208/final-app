package com.example.foodapp.data.database.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.foodapp.data.database.model.FoodDbModel

/**
 * Dao for managing Note table in the database.
 */
@Dao
interface FoodDao {

  @Query("SELECT * FROM FoodDbModel")
  fun getAllSync(): List<FoodDbModel>

  @Query("SELECT * FROM FoodDbModel WHERE id IN (:foodIds)")
  fun getFoodsByIdsSync(foodIds: List<Long>): List<FoodDbModel>

  @Query("SELECT * FROM FoodDbModel WHERE id LIKE :id")
  fun findById(id: Long): LiveData<FoodDbModel>

  @Query("SELECT * FROM FoodDbModel WHERE id = :id")
  fun findByIdSync(id: Long): FoodDbModel

  @Insert(onConflict = OnConflictStrategy.REPLACE)
  fun insert(FoodDbModel: FoodDbModel)

  @Insert
  fun insertAll(vararg FoodDbModel: FoodDbModel)

  @Query("DELETE FROM FoodDbModel WHERE id LIKE :id")
  fun delete(id: Long)

  @Query("DELETE FROM FoodDbModel WHERE id IN (:foodIds)")
  fun delete(foodIds: List<Long>)
}
