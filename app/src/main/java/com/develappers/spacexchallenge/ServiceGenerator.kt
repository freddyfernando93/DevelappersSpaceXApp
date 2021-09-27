package com.develappers.spacexchallenge

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import okhttp3.OkHttpClient

object ServiceGenerator {
    private val client = OkHttpClient.Builder().build()
    private val retrofit = Retrofit.Builder()
            .baseUrl("https://api.spacexdata.com/v3/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
    fun <T> buildService(service: Class<T>): T {
        return retrofit.create(service)
    }

}