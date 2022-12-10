package com.mealzapp.model

import com.mealzapp.model.api.MealsWebService
import com.mealzapp.model.response.MealCategoriesResponse
import com.mealzapp.model.response.MealResponse

class MealRepository(private val webService: MealsWebService = MealsWebService()) {
    private var cachedMeal = listOf<MealResponse>()
    suspend fun getMeal(): MealCategoriesResponse {
        return webService.getMeals().also {
            cachedMeal = it.categories
        }
    }

    fun getMeal(mealId: String): MealResponse? {
        return cachedMeal.firstOrNull { it.idCategory == mealId }
    }

    companion object {
        @Volatile
        private var instance: MealRepository? = null
        fun getInstance() = instance ?: synchronized(this) {
            instance ?: MealRepository().also { instance = it }
        }
    }
}