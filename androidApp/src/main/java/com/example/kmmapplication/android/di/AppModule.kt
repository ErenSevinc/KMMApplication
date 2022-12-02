package com.example.kmmapplication.android.di

import org.koin.androidx.viewmodel.dsl.viewModel
import com.example.kmmapplication.presentation.viewmodel.MovieDetailViewModel
import com.example.kmmapplication.presentation.viewmodel.MoviesPageViewModel
import org.koin.dsl.module

val appModule = module {
    viewModel { MoviesPageViewModel(get()) }
    viewModel { MovieDetailViewModel(get()) }
}