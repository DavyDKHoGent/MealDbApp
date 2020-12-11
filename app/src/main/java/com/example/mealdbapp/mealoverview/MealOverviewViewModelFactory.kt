package com.example.mealdbapp.mealoverview

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.mealdbapp.data.remote.MealApiService

class MealOverviewViewModelFactory(private val apiService: MealApiService, private val context: Context): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MealOverviewViewModel::class.java)){
            return MealOverviewViewModel(apiService, context) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }

}