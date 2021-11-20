package com.example.foodapp.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.foodapp.routing.FoodsRouter
import com.example.foodapp.routing.Screen
import com.example.foodapp.theme.FoodThemeSettings
import com.example.foodapp.util.fromHex


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
        Column() {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(color = Color.fromHex("#FFFFFF")),
            )
            {
                Box(Modifier.clickable { closeDrawerAction() }){
                    Image(
                        imageVector = Icons.Filled.Menu,
                        contentDescription = "Drawer",
                        colorFilter = ColorFilter.tint(Color.fromHex("#FF6600")),
                        modifier = Modifier.padding(16.dp),
                    )
                }
                Text(
                    text = "Food app",
                    modifier = Modifier
                        .align(Alignment.CenterVertically)
                        .width(200.dp),
                    color = Color.fromHex("#FF6600"),
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    softWrap = true
                )
                Image(
                    imageVector = Icons.Filled.Email,
                    contentDescription = "Drawer Header Icon",
                    colorFilter = ColorFilter.tint(Color.fromHex("#FF6600")),
                    modifier = Modifier.padding(16.dp),
                )
            }
            Divider(
                color = MaterialTheme.colors.onSurface.copy(alpha = .2f)
            )
        }
    }
}
