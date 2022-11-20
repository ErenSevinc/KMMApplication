package com.example.kmmapplication.presentation.viewmodel

import com.example.kmmapplication.base.BaseViewModel
import com.example.kmmapplication.data.model.MoviesResult
import com.example.kmmapplication.domain.GetPopularMoviesUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class MoviesPageViewModel constructor(
    private val getPopularMoviesUseCase: GetPopularMoviesUseCase = GetPopularMoviesUseCase()
) : BaseViewModel() {

    private val _popularMovies = MutableStateFlow<MoviesResult?>(null)
    val popularMovies: StateFlow<MoviesResult?> = _popularMovies

    init {
        getPopularMovies()
    }

    fun getPopularMovies() {
        baseScope.launch {
            getPopularMoviesUseCase.invoke(Unit)
                .collect {
                    _popularMovies.value = it
                }
        }
    }
}