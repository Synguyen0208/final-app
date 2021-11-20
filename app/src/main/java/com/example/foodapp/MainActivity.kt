package com.example.foodapp

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.ExperimentalFoundationApi
import com.example.foodapp.data.database.model.FoodDbModel


import com.example.foodapp.viewmodel.MainViewModel
import com.example.foodapp.viewmodel.MainViewModelFactory
import com.google.accompanist.pager.ExperimentalPagerApi


/**
 * Main activity for the app.
 */

class MainActivity : AppCompatActivity() {

  private val viewModel: MainViewModel by viewModels(factoryProducer = {
    MainViewModelFactory(
      this,
      (application as FoodApplication).dependencyInjector.repository
    )
  })
  @ExperimentalAnimationApi
  @ExperimentalPagerApi
  @ExperimentalFoundationApi
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContent{
      FoodApp(viewModel)
    }
  }
}
