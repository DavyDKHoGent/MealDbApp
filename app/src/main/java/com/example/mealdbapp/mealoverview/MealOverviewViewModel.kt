package com.example.mealdbapp.mealoverview

import android.content.Context
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mealdbapp.data.local.AppDatabase
import com.example.mealdbapp.data.remote.MealApiService
import com.example.mealdbapp.models.Meal
import kotlinx.coroutines.launch

class MealOverviewViewModel(private val apiService: MealApiService, context: Context) : ViewModel() {
    private var _meals = MutableLiveData<List<Meal>>()
    val meals : LiveData<List<Meal>>
    get() = _meals
    val dao = AppDatabase.getDatabase(context).mealDao()

    init {
        getMeals('b')
    }

    private fun getMeals(char: Char){
        viewModelScope.launch {
            try {
                dao.insertAll(apiService.getMealsByChar(char).meals)
                _meals.value = dao.getAllMealsByChar("$char%")
            } catch (e: Exception){
                Log.e("Erro api:", e.message, e)
            }
        }
    }
}