package com.mealzapp.ui.detail

import androidx.compose.animation.animateColor
import androidx.compose.animation.core.animateDp
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.updateTransition
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.max
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import coil.size.Scale
import coil.transform.CircleCropTransformation
import com.mealzapp.model.response.MealResponse
import com.mealzapp.ui.theme.MealzAppTheme
import java.lang.Float.min

@Composable
fun MealDetailScreen(meal: MealResponse?) {
//    var profilePictureState by remember { mutableStateOf(MealProfilePictureState.Normal) }
//    val transition = updateTransition(targetState = profilePictureState, label = "")
//
//    val imageSizeDp by transition.animateDp(targetValueByState={it.size}, label = "")
//    val color  by transition.animateColor(targetValueByState={it.color}, label = "")
//    val border  by transition.animateDp(targetValueByState={it.borderWidth}, label = "")
    val scrollState = rememberScrollState()
    val offset = min(1f,1-(scrollState.value/600f))
    val size by animateDpAsState(targetValue =max(100.dp,200.dp * offset) )
Surface(color = MaterialTheme.colors.background) {
    Column {
        Surface(elevation = 4.dp) {
            Row(modifier = Modifier.fillMaxWidth()) {
                Card(
                    modifier = Modifier.padding(16.dp),
                    shape = CircleShape,
                    border = BorderStroke(width = 2.dp, color = Color.Green)
                ) {
                    Image(
                        painter = rememberAsyncImagePainter(
                            model = ImageRequest.Builder(LocalContext.current)
                                .data(meal?.strCategoryThumb).transformations(
                                    listOf(CircleCropTransformation())
                                ).scale(Scale.FILL).build()
                        ),
                        contentDescription = "Meal Image",
                        modifier = Modifier
                            .size(size)
//                            .padding(8.dp)
                    )
                }
                Text(
                    text = meal?.strCategory ?: "Default Name",
                    modifier = Modifier
                        .padding(16.dp)
                        .align(Alignment.CenterVertically)
                )
            }
        }
        Column(modifier = Modifier.verticalScroll(scrollState)) {
            Text(text = "This is text element", modifier = Modifier.padding(32.dp))
            Text(text = "This is text element", modifier = Modifier.padding(32.dp))
            Text(text = "This is text element", modifier = Modifier.padding(32.dp))
            Text(text = "This is text element", modifier = Modifier.padding(32.dp))
            Text(text = "This is text element", modifier = Modifier.padding(32.dp))
            Text(text = "This is text element", modifier = Modifier.padding(32.dp))
            Text(text = "This is text element", modifier = Modifier.padding(32.dp))
            Text(text = "This is text element", modifier = Modifier.padding(32.dp))
            Text(text = "This is text element", modifier = Modifier.padding(32.dp))
           Text(text = "This is text element", modifier = Modifier.padding(32.dp))
            Text(text = "This is text element", modifier = Modifier.padding(32.dp))
            Text(text = "This is text element", modifier = Modifier.padding(32.dp))
            Text(text = "This is text element", modifier = Modifier.padding(32.dp))
            Text(text = "This is text element", modifier = Modifier.padding(32.dp))
            Text(text = "This is text element", modifier = Modifier.padding(32.dp))
            Text(text = "This is text element", modifier = Modifier.padding(32.dp))
            Text(text = "This is text element", modifier = Modifier.padding(32.dp))
            Text(text = "This is text element", modifier = Modifier.padding(32.dp))
        }
//        Button(modifier = Modifier.padding(16.dp),
//            onClick = { profilePictureState= if(profilePictureState==MealProfilePictureState.Normal){
//                MealProfilePictureState.Expanded
//            }else{
//                MealProfilePictureState.Normal
//            }}) {
//            Text(text = "Change state of meal profile picture")
//        }
    }
}
}

enum class MealProfilePictureState(val color:Color,val size:Dp,val borderWidth:Dp){
    Normal(Color.Magenta,120.dp,8.dp),
    Expanded(Color.Green,200.dp,24.dp)
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MealzAppTheme {
        MealDetailScreen(null)
    }
}