package com.mealzapp.model.api

import com.mealzapp.model.response.MealCategoriesResponse
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET


class MealsWebService {
    private var api:MealApi
    init {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://www.themealdb.com/api/json/v1/1/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        api = retrofit.create(MealApi::class.java)
    }

    suspend fun getMeals(): MealCategoriesResponse {
        return api.getMeals()
    }

    interface MealApi{
        @GET("categories.php")
        suspend fun getMeals(): MealCategoriesResponse
    }
}