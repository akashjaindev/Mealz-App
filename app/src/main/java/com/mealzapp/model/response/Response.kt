package com.mealzapp.model.response

data class MealCategoriesResponse(val categories: List<MealResponse>)

data class MealResponse(
    val idCategory: String,
    val strCategory: String,
    val strCategoryDescription: String,
    val strCategoryThumb: String,
)