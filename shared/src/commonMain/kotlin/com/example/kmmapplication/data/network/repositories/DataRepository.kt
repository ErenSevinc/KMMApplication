package com.example.kmmapplication.data.network.repositories

import com.example.kmmapplication.base.BaseRepository
import com.example.kmmapplication.data.model.MovieDetailResult
import com.example.kmmapplication.data.model.MoviesResult
import com.example.kmmapplication.data.network.NetworkModule
import com.example.kmmapplication.data.network.getClient
import com.example.kmmapplication.data.network.service.ApiService
import com.example.kmmapplication.data.network.service.ApiServiceImpl
import io.ktor.client.statement.*
import kotlinx.coroutines.flow.Flow

class DataRepository constructor(
    private val service: ApiService
) : BaseRepository() {

    suspend fun getPopularMovies() = service.getPopularMovies()
    suspend fun getMovieDetail(movieId: Long) = service.getMovieDetail(movieId)

}