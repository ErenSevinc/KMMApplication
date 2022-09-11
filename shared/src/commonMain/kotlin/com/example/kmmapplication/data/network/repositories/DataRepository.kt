package com.example.kmmapplication.data.network.repositories

import com.example.kmmapplication.base.BaseRepository
import com.example.kmmapplication.data.model.MovieResult
import com.example.kmmapplication.data.network.NetworkModule
import com.example.kmmapplication.data.network.service.ApiServiceImpl
import io.ktor.client.statement.*
import kotlinx.coroutines.flow.Flow

class DataRepository constructor(
    private val service: ApiServiceImpl = ApiServiceImpl(NetworkModule.getClient())
) : BaseRepository() {

    fun getPopularMovies(): Flow<MovieResult> {
        return fetch {
            service.getPopularMovies()
        }
    }
}