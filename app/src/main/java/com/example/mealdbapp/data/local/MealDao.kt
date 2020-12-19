package com.example.mealdbapp.data.local

import androidx.room.*
import com.example.mealdbapp.models.Meal

@Dao
interface MealDao {
    @Transaction
    @Query("select * from meals where name like :char")
    suspend fun getAllMealsByChar(char: String): List<Meal>

    @Transaction
    @Query("select * from meals where id=:id")
    suspend fun getMeal(id: String): Meal

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(list: List<Meal>)
}