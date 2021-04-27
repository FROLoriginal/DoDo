package com.example.dodo.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Client {

    private var retrofit: Retrofit? = null

    fun getInstance(baseUrl: String): Retrofit {
        if (retrofit == null){
            return Retrofit
                .Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
        return retrofit!!

    }

}
