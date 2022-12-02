package com.example.kmmapplication.presentation.viewmodel

import com.example.kmmapplication.base.BaseViewModel
import com.example.kmmapplication.data.model.MovieDetailResult
import com.example.kmmapplication.domain.GetMovieDetailUseCase
import com.example.kmmapplication.presentation.IsSuccess
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class MovieDetailViewModel constructor(
    private val getMovieDetailUseCase: GetMovieDetailUseCase
) : BaseViewModel() {

    private val _movieDetail = MutableStateFlow<MovieDetailResult?>(null)
    val movieDetail: StateFlow<MovieDetailResult?> = _movieDetail

    private val _isSuccess = MutableStateFlow<IsSuccess>(IsSuccess.LOADING)
    val isSuccess: StateFlow<IsSuccess> = _isSuccess

    init {
        _isSuccess.value = IsSuccess.LOADING
        _movieDetail.value = null
    }

    fun getMovieDetail(movieId: Long) {
        baseScope.launch {
            kotlin.runCatching {
                getMovieDetailUseCase.getMovieDetail(movieId)
            }.onSuccess {
                _movieDetail.value = it
                _isSuccess.value = IsSuccess.SUCCESS
            }.onFailure {
                _isSuccess.value = IsSuccess.FAIL
            }
        }
    }
}