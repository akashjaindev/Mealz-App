package com.mealzapp.ui.meals

import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mealzapp.model.MealRepository
import com.mealzapp.model.response.MealCategoriesResponse
import com.mealzapp.model.response.MealResponse
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class MealsCategoriesViewModel(private val repository:MealRepository = MealRepository()) : ViewModel() {
    val mealState : MutableState<List<MealResponse>> = mutableStateOf(emptyList())
    init {
        viewModelScope.launch(Dispatchers.IO){
            val meals = getMeal()
            mealState.value = meals
        }
    }
    private suspend fun getMeal(): List<MealResponse>{
      return repository.getMeal().categories
    }
}