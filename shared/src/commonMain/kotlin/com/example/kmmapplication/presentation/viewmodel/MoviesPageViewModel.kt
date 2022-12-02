package com.example.kmmapplication.presentation.viewmodel

import com.example.kmmapplication.base.BaseViewModel
import com.example.kmmapplication.data.model.MoviesResult
import com.example.kmmapplication.domain.GetPopularMoviesUseCase
import com.example.kmmapplication.presentation.IsSuccess
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class MoviesPageViewModel constructor(
    private val getPopularMoviesUseCase: GetPopularMoviesUseCase
) : BaseViewModel() {

    private val _popularMovies = MutableStateFlow<MoviesResult?>(null)
    val popularMovies: StateFlow<MoviesResult?> = _popularMovies

    private val _isSuccess = MutableStateFlow<IsSuccess>(IsSuccess.LOADING)
    val isSuccess: StateFlow<IsSuccess> = _isSuccess

    init {
        _isSuccess.value = IsSuccess.LOADING
        _popularMovies.value = null
    }

    fun getPopularMovies() {
        baseScope.launch {
            kotlin.runCatching {
                getPopularMoviesUseCase.getPopularMovies()
            }.onSuccess {
                _popularMovies.value = it
                _isSuccess.value = IsSuccess.SUCCESS
            }.onFailure {
                _isSuccess.value = IsSuccess.FAIL
            }
        }
    }
}