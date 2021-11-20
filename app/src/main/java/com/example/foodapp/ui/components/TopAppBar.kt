package com.example.foodapp.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.List
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.example.foodapp.R
import com.example.foodapp.util.fromHex

@Composable
fun TopAppBar(
    title: String,
    icon: ImageVector,
    onIconClick: () -> Unit,
    search:MutableState<String>,
) {
    Column() {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = Color.fromHex("#FFFFFF")),
        )
        {
            Image(
                imageVector = icon,
                contentDescription = "Drawer Header Icon",
                colorFilter = ColorFilter.tint(Color.fromHex("#FF6600")),
                modifier = Modifier.padding(16.dp),
            )

            Text(
                text = title,
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
            Box(Modifier.clickable { onIconClick() }){
                Image(
                    imageVector = Icons.Filled.Menu,
                    contentDescription = "Drawer",
                    colorFilter = ColorFilter.tint(Color.fromHex("#FF6600")),
                    modifier = Modifier.padding(16.dp),
                )
            }

        }
        SearchBar(search = search)
        Divider(
            color = MaterialTheme.colors.onSurface.copy(alpha = .2f)
        )
    }
}