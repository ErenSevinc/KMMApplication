package com.example.kmmapplication.data.network.service

import com.example.kmmapplication.data.model.MovieDetailResult
import com.example.kmmapplication.data.model.MoviesResult
import io.ktor.client.*
import io.ktor.client.statement.*

interface ApiService  {
    suspend fun getPopularMovies(): MoviesResult
    suspend fun getMovieDetail(movieId: Long): MovieDetailResult
}