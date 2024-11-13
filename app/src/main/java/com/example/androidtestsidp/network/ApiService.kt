package com.example.androidtestsidp.network

import com.example.androidtestsidp.model.Item
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface ApiService {
    @GET("64KB.json")
    suspend fun fetchItems(): List<Item>
}

fun provideRetrofit(): Retrofit {
    return Retrofit.Builder()
        .baseUrl("https://microsoftedge.github.io/Demos/json-dummy-data/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
}

fun provideApiService(retrofit: Retrofit): ApiService {
    return retrofit.create(ApiService::class.java)
}