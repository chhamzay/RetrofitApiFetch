package com.example.retrofiltsapi

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

object RetrofitBuilder {
    val urlapi="https://fakestoreapi.com/"

    fun getInstance():Retrofit{
        return Retrofit.Builder()
            .baseUrl(urlapi)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}