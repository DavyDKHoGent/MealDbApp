package com.example.mealdbapp.data.remote

import com.example.mealdbapp.BuildConfig
import com.example.mealdbapp.models.GetMealsApiResponse
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

private const val BASE_URL = "https://www.themealdb.com/api/json/v1/1/"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory()).build()

private val interceptor = HttpLoggingInterceptor()
    .setLevel(if(BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY else HttpLoggingInterceptor.Level.NONE)

private val client = OkHttpClient.Builder()
    .addInterceptor(interceptor)
    .build()

private  val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .client(client)
    .build()

interface MealApiService {
    @GET("search.php?")
    suspend fun getMealsByChar(@Query("f") char: Char): GetMealsApiResponse
}

object MealApi {
    val retrofitService : MealApiService by lazy {
        retrofit.create(MealApiService::class.java)
    }
}