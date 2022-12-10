package com.mealzapp.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.mealzapp.ui.detail.MealDetailScreen
import com.mealzapp.ui.detail.MealDetailViewModel
import com.mealzapp.ui.meals.MealCategoriesScreen
import com.mealzapp.ui.theme.MealzAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MealzAppTheme {
                FoodApp()
            }
        }
    }
}

@Composable
private fun FoodApp() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "destination_meals_route") {
        composable(route = "destination_meals_route") {
            MealCategoriesScreen { navigationCategoryId ->
                navController.navigate("destination_meals_details/$navigationCategoryId")
            }
        }
        composable(
            route = "destination_meals_details/{meal_category_id}",
            arguments = listOf(navArgument("meal_category_id") {
                type = NavType.StringType
            })
        ) {
            val viewModel: MealDetailViewModel = viewModel()
            MealDetailScreen(meal = viewModel.mealState.value)
        }
    }
}