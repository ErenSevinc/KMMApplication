package com.example.kmmapplication.data.network.service

import com.example.kmmapplication.data.model.MoviesResult
import io.ktor.client.*
import io.ktor.client.statement.*

interface ApiService  {

    suspend fun getPopularMovies(): MoviesResult
}