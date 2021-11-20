package com.example.foodapp.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import com.example.foodapp.data.database.dao.FoodDao
import com.example.foodapp.domain.model.FoodModel
import com.example.foodapp.data.database.dbmapper.DbMapper
import com.example.foodapp.data.database.model.FoodDbModel
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

/**
 * {@inheritDoc}
 */
@DelicateCoroutinesApi
class RepositoryImpl(
  private val FoodDao: FoodDao,
  private val dbMapper: DbMapper
) : Repository {

  private val FoodsLiveData: MutableLiveData<List<FoodDbModel>> by lazy {
    MutableLiveData<List<FoodDbModel>>()
  }
  init {
    initDatabase(this::updateFoodsLiveData)
  }

  /**
   * Populates database with colors if it is empty.
   */
  @DelicateCoroutinesApi
  private fun initDatabase(postInitAction: () -> Unit) {
    GlobalScope.launch {

      // Prepopulate Foods
      val Foods = FoodDbModel.DEFAULT_FOODS.toTypedArray()
      val dbFoods = FoodDao.getAllSync()
      if (dbFoods.isNullOrEmpty()) {
        FoodDao.insertAll(*Foods)
      }

      postInitAction.invoke()
    }
  }
  private fun getAllFoodsDependingOnTrashStateSync(): List<FoodDbModel> {
    val dbFoods: List<FoodDbModel> =
      FoodDao.getAllSync()
    return dbFoods;
  }
  override fun getAllFoods(): LiveData<List<FoodDbModel>> = FoodsLiveData

  override fun getFood(id: Long): LiveData<FoodDbModel> =
    Transformations.map(FoodDao.findById(id)) {
      dbMapper.mapFood(it)
    }

  override fun insertFood(Food: FoodDbModel) {
    FoodDao.insert(dbMapper.mapDbFood(Food))
    updateFoodsLiveData()
  }

  override fun deleteFood(id: Long) {
    FoodDao.delete(id)
    updateFoodsLiveData()
  }

  override fun deleteFoods(FoodIds: List<Long>) {
    FoodDao.delete(FoodIds)
    updateFoodsLiveData()
  }

  private fun updateFoodsLiveData() {
    FoodsLiveData.postValue(getAllFoodsDependingOnTrashStateSync())
  }
}
