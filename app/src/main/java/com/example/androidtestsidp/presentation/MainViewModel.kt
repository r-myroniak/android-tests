package com.example.androidtestsidp.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.androidtestsidp.network.Repository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class MainViewModel(private val repository: Repository) : ViewModel() {

    private val _itemCount = MutableStateFlow<Int>(0)
    val itemCount: StateFlow<Int> get() = _itemCount

    fun fetchAndCountItems() {
        viewModelScope.launch {
            val items = repository.getItems()
            _itemCount.value = items.size
        }
    }
}