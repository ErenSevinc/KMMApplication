package com.example.kmmapplication

import com.example.kmmapplication.base.BaseViewModel
import com.example.kmmapplication.data.model.MoviesResult
import com.example.kmmapplication.domain.GetPopularMoviesUseCase
import io.ktor.client.statement.*
import kotlinx.coroutines.Delay
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

open class CommonViewModel constructor(
    private val getPopularMoviesUseCase: GetPopularMoviesUseCase = GetPopularMoviesUseCase()
) : BaseViewModel() {

    private val _popularMovies = MutableStateFlow<MoviesResult?>(null)
    val popularMovies: StateFlow<MoviesResult?> = _popularMovies

    private val _isSuccess = MutableStateFlow<Boolean>(false)
    val isSuccess: StateFlow<Boolean> = _isSuccess

    init {
        getPopularMovies()
    }

    private fun getPopularMovies() {
        baseScope.launch {
//            delay(5000L)
            getPopularMoviesUseCase.invoke(Unit)
                .collect {
                    _popularMovies.value = it
//                    _isSuccess.value = true
                }
        }
    }
}