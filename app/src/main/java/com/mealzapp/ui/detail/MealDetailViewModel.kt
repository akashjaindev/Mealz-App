package com.mealzapp.ui.detail

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.mealzapp.model.MealRepository
import com.mealzapp.model.response.MealResponse

class MealDetailViewModel(savedStateHandle: SavedStateHandle) : ViewModel() {
    private val repository: MealRepository = MealRepository.getInstance()
    var mealState = mutableStateOf<MealResponse?>(null)

    init {
        val mealId = savedStateHandle.get<String>("meal_category_id") ?: ""
        mealState.value = repository.getMeal(mealId)
    }
}