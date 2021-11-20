import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import coil.compose.rememberImagePainter
import com.example.foodapp.R
import com.example.foodapp.data.database.model.FoodDbModel
import com.example.foodapp.util.fromHex
import kotlin.random.Random

@ExperimentalAnimationApi
@Composable
fun MyAlertDialog() {
    val random = List(1) { Random.nextInt(FoodDbModel.DEFAULT_FOODS.size) }
    val shouldShowDialog = remember { mutableStateOf(false) }
    var isVisible by remember { mutableStateOf(false) };
    ExtendedFloatingActionButton(
        text = {
            Text(text = "Random")
        },
        onClick = {
            shouldShowDialog.value = true;
        },
        icon = { Icon(Icons.Filled.Search, "") },
        elevation = FloatingActionButtonDefaults.elevation(),
        backgroundColor = Color.fromHex("#FF6600"),
    )
    if(!shouldShowDialog.value){
        isVisible=false
    }
    if (shouldShowDialog.value) {

        val food = FoodDbModel.DEFAULT_FOODS[random[0]]

        Dialog(onDismissRequest = { shouldShowDialog.value = false }) {
            Surface(
                modifier = Modifier
                    .width(300.dp)
                    .height(300.dp)
                    .background(
                        Brush.verticalGradient(
                            colors = listOf(
                                Color.Yellow,
                                Color.fromHex("#ee4d2d")
                            )
                        )
                    )
                    .padding(5.dp),
                shape = RoundedCornerShape(5.dp),
                color = Color.White
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    AnimatedVisibility(
                        visible = isVisible,
                        enter = fadeIn(animationSpec = tween(durationMillis = 5000)),
                        exit = fadeOut(animationSpec = tween(durationMillis = 5000))
                    ) {
                        Card(
//                            modifier = Modifier.fillMaxWidth(),
                            shape = RoundedCornerShape(15.dp),
                            elevation = 5.dp
                        ) {
                            Box(
                                modifier = Modifier.height(200.dp)
                            ) {
                                Column {
                                    Image(
                                        painter = rememberImagePainter(
                                            data = food.image,
                                            builder = {
                                                crossfade(true)
                                                placeholder(drawableResId = R.drawable.maxresdefault)
                                            }
                                        ),
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .fillMaxHeight(),
                                        contentDescription = "Food Image",

                                        )
                                }
                            }
                            Box(
                                modifier = Modifier
                                    .fillMaxSize(),
                                contentAlignment = Alignment.BottomStart
                            ) {
                                Column(
                                    modifier = Modifier.
                                    align(Alignment.BottomCenter),
                                    horizontalAlignment = Alignment.CenterHorizontally
                                ) {
                                    Text(
                                        text = food.name,
                                        style = TextStyle(
                                            textAlign = TextAlign.Center,
                                            fontSize = 20.sp
                                        )
                                    )
                                    Text(
                                        text = food.price.toString() + "đ",
                                        style = TextStyle(
                                            color = Color.Red,
                                            textAlign = TextAlign.Center,
                                            fontSize = 20.sp
                                        )
                                    )
                                }
                            }
                        }
                    }
                    Button(
                        onClick = { isVisible=true },
                        colors = ButtonDefaults.buttonColors(
                            backgroundColor =Color.fromHex("#FF6600"),
                        )
                    ) {
                        Text(text = "Kết quả")
                    }
                }

            }
        }
    }
}