package com.example.androidtestsidp.di

import com.example.androidtestsidp.presentation.MainViewModel
import com.example.androidtestsidp.network.Repository
import com.example.androidtestsidp.network.provideApiService
import com.example.androidtestsidp.network.provideRetrofit
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    single { provideRetrofit() }
    single { provideApiService(get()) }
    single { Repository(get()) }
    viewModel { MainViewModel(get()) }
}