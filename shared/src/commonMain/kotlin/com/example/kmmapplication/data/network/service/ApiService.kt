package com.example.kmmapplication.data.network.service

import com.example.kmmapplication.data.model.MovieResult
import io.ktor.client.*
import io.ktor.client.statement.*

interface ApiService  {

    suspend fun getPopularMovies(): MovieResult
}