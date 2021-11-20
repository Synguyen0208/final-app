package com.example.foodapp.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.foodapp.routing.FoodsRouter
import com.example.foodapp.routing.Screen
import com.example.foodapp.theme.FoodThemeSettings


@Composable
fun AppDrawer(
    currentScreen: Screen,
    closeDrawerAction: () -> Unit
)
{
    Column(
        modifier = Modifier.fillMaxSize()
    )
    {
        TopAppBar(
            title = "FoodApp",
            icon = Icons.Filled.Menu,
            onIconClick = {
                closeDrawerAction()
            }
        )
    }
}
