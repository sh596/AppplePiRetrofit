package com.example.retrofit

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface MusicService {
    @GET("?method=chart.gettoptracks&format=json&limit=50")
    fun getChart(@Query("api_key") apiKey : String): Call<RetrofitData>
}