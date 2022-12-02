package com.example.kmmapplication.di

import com.example.kmmapplication.data.network.getClient
import com.example.kmmapplication.data.network.repositories.DataRepository
import com.example.kmmapplication.data.network.service.ApiService
import com.example.kmmapplication.data.network.service.ApiServiceImpl
import com.example.kmmapplication.domain.GetMovieDetailUseCase
import com.example.kmmapplication.domain.GetPopularMoviesUseCase
import com.example.kmmapplication.platformModule
import com.example.kmmapplication.presentation.viewmodel.MovieDetailViewModel
import com.example.kmmapplication.presentation.viewmodel.MoviesPageViewModel
import org.koin.core.Koin
import org.koin.core.context.startKoin
import org.koin.core.parameter.parametersOf
import org.koin.dsl.KoinAppDeclaration
import org.koin.dsl.module
import kotlin.reflect.KClass

fun initKoin(appDeclaration: KoinAppDeclaration = {}) = startKoin {
    appDeclaration()
    modules(commonModule, platformModule())
}

fun initKoin() = initKoin {  }

val commonModule = module {
    single { getClient() }
    single<ApiService> {ApiServiceImpl(get())}
    single { DataRepository(get()) }
    single { GetPopularMoviesUseCase(get()) }
    single { GetMovieDetailUseCase(get()) }
    factory { MoviesPageViewModel(get()) }
    factory { MovieDetailViewModel(get()) }
}

fun <T> Koin.getDependency(_class: KClass<*>): T {
    return get(_class, null) { parametersOf(_class.simpleName) } as T
}