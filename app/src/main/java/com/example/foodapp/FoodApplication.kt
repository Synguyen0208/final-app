package com.example.foodapp

import android.app.Application
import com.example.foodapp.dependencyinjection.DependencyInjector

/**
 * Application class responsible for initializing the dependency injector.
 */
class FoodApplication : Application() {

  lateinit var dependencyInjector: DependencyInjector

  override fun onCreate() {
    super.onCreate()
    initDependencyInjector()
  }

  private fun initDependencyInjector() {
    dependencyInjector = DependencyInjector(this)
  }
}
