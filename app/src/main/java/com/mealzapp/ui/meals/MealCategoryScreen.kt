package com.mealzapp.ui.meals

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import com.mealzapp.model.response.MealResponse
import com.mealzapp.ui.theme.MealzAppTheme

@Composable
fun MealCategoriesScreen() {
    val viewModel:MealsCategoriesViewModel = viewModel()
    val meals = viewModel.mealState.value
    LazyColumn(contentPadding = PaddingValues(16.dp)){
        items(meals){meal->
            MealCategory(meal = meal)
        }
    }
}

@Composable
fun MealCategory(meal:MealResponse){
    Card(shape = RoundedCornerShape(8.dp), elevation = 2.dp,
    modifier = Modifier.fillMaxWidth().padding(top = 16.dp)) {
        Row {
            // Image
            AsyncImage(
                model = meal.strCategoryThumb,
                contentDescription = meal.strCategory,
                modifier = Modifier.size(88.dp).padding(4.dp)
            )
            Column(modifier = Modifier.align(Alignment.CenterVertically).padding(16.dp)) {
                Text(text = meal.strCategory, style = MaterialTheme.typography.h6)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MealzAppTheme {
        MealCategoriesScreen()
    }
}