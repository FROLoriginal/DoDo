package com.example.dodo.network

import com.example.dodo.model.Meals
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface RetrofitServices {

    @GET("api/json/v1/1/filter.php")
    suspend fun getMealByIngredient(@Query("i") ingredient: String): Response<Meals>

}
