package com.example.foodapp.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.*
import androidx.compose.material.ButtonDefaults.IconSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.material.icons.outlined.ArrowForward
import androidx.compose.material.icons.outlined.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.R
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import com.example.foodapp.util.fromHex

@Composable
fun SearchBar(
    modifier: Modifier = Modifier,
    search:MutableState<String>,
) {
    Box() {
        TextField(
            value = search.value,
            onValueChange = {
                search.value = it
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 10.dp, end = 10.dp, bottom = 10.dp)
            ,
            placeholder = { SearchHint() }
        )
        Box(modifier = Modifier.align(Alignment.CenterEnd)) {
            Button(
                onClick = {},
                modifier = Modifier
                    .padding(start = 1.dp, end = 10.dp, bottom = 10.dp)
                    .height(55.dp),
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = Color.fromHex("#FF6600"),
                )
            ) {
                Icon(
                    imageVector = Icons.Outlined.Search,
                    tint = Color.fromHex("#222222"),
                    contentDescription = "Search"
                )
            }
        }

    }


}

@Composable
private fun SearchHint() {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .wrapContentSize()
    ) {
        Icon(
            imageVector = Icons.Outlined.Search,
            tint = Color.fromHex("#222222"),
            contentDescription = "Search"
        )
        Spacer(Modifier.width(8.dp))
        Text(
            text = "Search",
            color = Color.fromHex("#222222")
        )
    }
}

@Composable
fun mirroringIcon(ltrIcon: ImageVector, rtlIcon: ImageVector): ImageVector =
    if (LocalLayoutDirection.current == LayoutDirection.Ltr) ltrIcon else rtlIcon

@Composable
fun mirroringBackIcon() = mirroringIcon(
    ltrIcon = Icons.Outlined.ArrowBack, rtlIcon = Icons.Outlined.ArrowForward
)