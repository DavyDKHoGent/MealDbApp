package com.example.mealdbapp.mealdetail

import android.content.Context
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mealdbapp.data.local.AppDatabase
import com.example.mealdbapp.models.Meal
import kotlinx.coroutines.launch

class MealDetailViewModel(context: Context) : ViewModel() {
    private var _meal = MutableLiveData<Meal>()
    val meal: LiveData<Meal>
    get() = _meal
    private val dao = AppDatabase.getDatabase(context).mealDao()

    fun updateMeal(id: String){
        viewModelScope.launch {
            try {
                _meal.value = dao.getMeal(id)
            } catch (e: Exception){
                Log.e("Erro api:", e.message, e)
            }
        }
    }
}