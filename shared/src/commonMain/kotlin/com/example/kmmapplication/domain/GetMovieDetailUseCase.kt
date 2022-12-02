package com.example.kmmapplication.domain

import com.example.kmmapplication.base.BaseUseCase
import com.example.kmmapplication.data.model.MovieDetailResult

import com.example.kmmapplication.data.network.repositories.DataRepository
import kotlinx.coroutines.flow.Flow

class GetMovieDetailUseCase constructor(
    private val repository: DataRepository
) {
    //: BaseUseCase<Long, MovieDetailResult>() {

//    override fun buildUseCase(params: Long): Flow<MovieDetailResult> {
//        return repository.getMovieDetail(params)
//    }
    suspend fun getMovieDetail(movieId: Long): MovieDetailResult {
        return repository.getMovieDetail(movieId)
    }
}