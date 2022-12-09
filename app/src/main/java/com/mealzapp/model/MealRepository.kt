package com.mealzapp.model

import com.mealzapp.model.api.MealsWebService
import com.mealzapp.model.response.MealCategoriesResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MealRepository(private val webService:MealsWebService= MealsWebService()) {
    suspend fun getMeal(): MealCategoriesResponse {
        return webService.getMeals()
    }
}