package com.example.kmmapplication.presentation.viewmodel

import com.example.kmmapplication.base.BaseViewModel
import com.example.kmmapplication.data.model.MovieDetailResult
import com.example.kmmapplication.domain.GetMovieDetailUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class MovieDetailViewModel constructor(
    private val getMovieDetailUseCase: GetMovieDetailUseCase
) : BaseViewModel() {

    private val _movieDetail = MutableStateFlow<MovieDetailResult?>(null)
    val movieDetail: StateFlow<MovieDetailResult?> = _movieDetail

    private val _isSuccess = MutableStateFlow<Boolean>(false)
    val isSuccess: StateFlow<Boolean> = _isSuccess

    init {
        _movieDetail.value = null
    }

    fun getMovieDetail(movieId: Long) {
        baseScope.launch {
            kotlin.runCatching {
                getMovieDetailUseCase.getMovieDetail(movieId)
            }.onSuccess {
                _movieDetail.value = it
                _isSuccess.value = true
            }.onFailure {
                _isSuccess.value = false
            }
//            getMovieDetailUseCase.getMovieDetail(movieId)
//                .collect {
//                    _movieDetail.value = it
//                    _isSuccess.value = true
//                }
        }
    }
}