package com.example.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object MusicClient {
    private val BASE_URL = "https://ws.audioscrobbler.com/2.0/"
    private var instance: Retrofit? = null;

    fun service(): MusicService = retrofit().create(MusicService::class.java)

    private fun retrofit(): Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

}
