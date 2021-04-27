package com.example.dodo.network

class RetrofitDataProvider {

    private val BASE_URL = "https://www.themealdb.com/"

    fun getServices(): RetrofitServices {
        return Client().getInstance(BASE_URL)
            .create(RetrofitServices::class.java)
    }

}
