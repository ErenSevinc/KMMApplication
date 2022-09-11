package com.example.kmmapplication.data.network.service

import com.example.kmmapplication.data.model.MovieResult
import com.example.kmmapplication.data.network.NetworkModule
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*

class ApiServiceImpl constructor(
    private val client: HttpClient
): ApiService {

    override suspend fun getPopularMovies(): MovieResult {
        return client.get(NetworkModule.BASE_URL) {
            url {
                path("3/movie/popular")
                parameter(key = "api_key", value = NetworkModule.API_KEY)
                parameter(key = "language", value = "tr-TR")
                parameter(key = "page", value = 1)
            }
        }.body()
    }


}