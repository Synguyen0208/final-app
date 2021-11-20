package com.example.foodapp.dependencyinjection

import android.content.Context
import androidx.room.Room
import com.example.foodapp.data.database.AppDatabase
import com.example.foodapp.data.database.dbmapper.DbMapper
import com.example.foodapp.data.database.dbmapper.DbMapperImpl
import com.example.foodapp.data.repository.Repository
import com.example.foodapp.data.repository.RepositoryImpl

/**
 * Provides dependencies across the app.
 */
class DependencyInjector(applicationContext: Context) {

  val repository: Repository by lazy { provideRepository(database) }

  private val database: AppDatabase by lazy { provideDatabase(applicationContext) }

  private val dbMapper: DbMapper = DbMapperImpl()

  private fun provideDatabase(applicationContext: Context): AppDatabase =
    Room.databaseBuilder(
      applicationContext,
      AppDatabase::class.java,
      AppDatabase.DATABASE_NAME
    ).build()

  private fun provideRepository(database: AppDatabase): Repository {
    val foodDao = database.foodDao()

    return RepositoryImpl(foodDao, dbMapper)
  }
}
