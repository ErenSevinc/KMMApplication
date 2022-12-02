package com.example.kmmapplication.presentation.viewmodel

import com.example.kmmapplication.base.BaseViewModel
import com.example.kmmapplication.data.model.MoviesResult
import com.example.kmmapplication.domain.GetPopularMoviesUseCase
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class MoviesPageViewModel constructor(
    private val getPopularMoviesUseCase: GetPopularMoviesUseCase
) : BaseViewModel() {

    private val _popularMovies = MutableStateFlow<MoviesResult?>(null)
    val popularMovies: StateFlow<MoviesResult?> = _popularMovies

    private val _isSuccess = MutableStateFlow<Boolean>(false)
    val isSuccess: StateFlow<Boolean> = _isSuccess

    init {
        _popularMovies.value = null
    }

    fun getPopularMovies() {
        baseScope.launch {
            kotlin.runCatching {
                getPopularMoviesUseCase.getPopularMovies()
            }.onSuccess {
                _popularMovies.value = it
                _isSuccess.value = true
            }.onFailure {
                _isSuccess.value = false
            }
        }
    }
}