package com.example.foodapp.routing

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

/**
 * Class defining all possible screens in the app.
 */
sealed class Screen {
  object Food : Screen()
  object Random : Screen()
}

/**
 * Allows you to change the screen in the [MainActivity]
 *
 * Also keeps track of the current screen.
 */
object FoodsRouter {
  var currentScreen: Screen by mutableStateOf(Screen.Food)

  fun navigateTo(destination: Screen) {
    currentScreen = destination
  }
}
