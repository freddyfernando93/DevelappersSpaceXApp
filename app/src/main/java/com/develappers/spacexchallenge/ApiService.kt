package com.develappers.spacexchallenge

import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
  @GET("launches")
  fun getLaunches():Call<MutableList<LaunchModel>>
}