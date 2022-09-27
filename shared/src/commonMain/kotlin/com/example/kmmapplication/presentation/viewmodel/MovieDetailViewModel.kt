package com.example.kmmapplication.presentation.viewmodel

import com.example.kmmapplication.base.BaseViewModel
import com.example.kmmapplication.data.model.MovieDetailResult
import com.example.kmmapplication.domain.GetMovieDetailUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class MovieDetailViewModel constructor(
    private val getMovieDetailUseCase: GetMovieDetailUseCase = GetMovieDetailUseCase()
) : BaseViewModel() {

    private val _movieDetail = MutableStateFlow<MovieDetailResult?>(null)
    val movieDetail: StateFlow<MovieDetailResult?> = _movieDetail

    fun getMovieDetail(movieId: Long) {
        baseScope.launch {
            getMovieDetailUseCase.invoke(movieId)
                .collect {
                    _movieDetail.value = it
                }
        }
    }
}