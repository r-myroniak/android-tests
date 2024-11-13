package com.example.androidtestsidp.network

import com.example.androidtestsidp.model.Item

class Repository(private val apiService: ApiService) {
    suspend fun getItems(): List<Item> = apiService.fetchItems()
}