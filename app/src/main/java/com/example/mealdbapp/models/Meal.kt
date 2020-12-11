package com.example.mealdbapp.models

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize

@Entity(tableName = "meals")
@Parcelize
data class Meal(
    @PrimaryKey
    @Json(name = "idMeal") val id: String,
    @Json(name = "strMeal") val name: String,
    @Json(name = "strCategory") val category: String,
    @Json(name = "strArea") val area: String,
    @Json(name= "strInstructions") val instructions: String,
    @Json(name = "strMealThumb") val thumbnail: String,
    @Json(name= "strYoutube") val video: String
) : Parcelable