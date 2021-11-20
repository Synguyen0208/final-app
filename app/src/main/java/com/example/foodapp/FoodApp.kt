package com.example.foodapp

import MyAlertDialog
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.unit.dp
import com.example.foodapp.data.database.model.FoodDbModel
import com.example.foodapp.domain.model.FoodModel
import com.example.foodapp.routing.Screen
import com.example.foodapp.theme.FoodTheme
import com.example.foodapp.ui.components.*
import com.example.foodapp.viewmodel.MainViewModel
import com.google.accompanist.insets.ProvideWindowInsets
import com.google.accompanist.pager.*
import kotlinx.coroutines.launch
import kotlin.random.Random

@ExperimentalAnimationApi
@ExperimentalPagerApi
@ExperimentalFoundationApi
@Composable
fun FoodApp(viewModel: MainViewModel) {
    val foods: List<FoodDbModel> by viewModel
        .foods
        .observeAsState(listOf())
    val scaffoldState: ScaffoldState = rememberScaffoldState()
    val coroutineScope = rememberCoroutineScope()
    val search = remember { mutableStateOf("") };

    ProvideWindowInsets {
        FoodTheme {
            Scaffold(
                scaffoldState = scaffoldState,
                topBar = {
                    TopAppBar(
                        title = "Đường Mỹ Khê 3, P.Phước Mỹ, Sơn Trà, Đà Nẵng",
                        icon = Icons.Filled.LocationOn,
                        onIconClick = {
                            coroutineScope.launch {
                                scaffoldState.drawerState.open()
                            }
                        },
                        search = search,
                    )
                },
                bottomBar = {}
                ,
                drawerContent = {
                    AppDrawer(
                        currentScreen = Screen.Food,
                        closeDrawerAction = {
                            coroutineScope.launch {
                                scaffoldState.drawerState.close()
                            }
                        }
                    )
                },
                content = {
                    Column {
                        FoodList(
                            foods = foods,
                            onNoteCheckedChange = { },
                            onNoteClick = {}
                        )
                    }
                },
                floatingActionButtonPosition = FabPosition.Center,
                isFloatingActionButtonDocked = true,
                floatingActionButton = {
                    MyAlertDialog()
                },
            )
        }
    }
}

@ExperimentalPagerApi
@ExperimentalFoundationApi
@OptIn(ExperimentalAnimationApi::class)
@Composable
private fun FoodList(
    foods: List<FoodDbModel>,
    onNoteCheckedChange: (FoodModel) -> Unit,
    onNoteClick: (FoodModel) -> Unit,
) {
    val backgroundShape: androidx.compose.ui.graphics.Shape = RoundedCornerShape(4.dp)

    val scroll = rememberScrollState(0)
    Column {
        LazyVerticalGrid(
            cells = GridCells.Adaptive(minSize = 162.dp),
            contentPadding = PaddingValues(start = 10.dp, end = 10.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
        ) {
            items(foods) { food ->
                FoodItem(food = food)
            }
        }

    }

}
