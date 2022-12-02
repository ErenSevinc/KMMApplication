package com.example.kmmapplication.domain

import com.example.kmmapplication.base.BaseUseCase
import com.example.kmmapplication.data.model.MoviesResult
import com.example.kmmapplication.data.network.repositories.DataRepository
import io.ktor.client.statement.*
import kotlinx.coroutines.flow.Flow

class GetPopularMoviesUseCase constructor(
    private val repository: DataRepository
) {
    //: BaseUseCase<Unit, MoviesResult>() {

//    override fun buildUseCase(params: Unit): Flow<MoviesResult> {
//        return repository.getPopularMovies()
//    }
    suspend fun getPopularMovies(): MoviesResult {
       return repository.getPopularMovies()
    }
}