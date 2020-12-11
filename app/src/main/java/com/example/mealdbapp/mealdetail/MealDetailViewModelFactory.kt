package com.example.mealdbapp.mealdetail

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.mealdbapp.data.remote.MealApiService
import com.example.mealdbapp.mealoverview.MealOverviewViewModel

class MealDetailViewModelFactory(private val context: Context): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MealDetailViewModel::class.java)){
            return MealDetailViewModel(context) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }

}