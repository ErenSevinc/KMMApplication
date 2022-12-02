package com.example.kmmapplication.data.network


import io.ktor.client.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.plugins.logging.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json

class NetworkModule {
    companion object {
        const val BASE_URL = "https://api.themoviedb.org/"
        const val API_KEY = "6a3250b8b666ace2104278cd40e42255"
    }
}

fun getClient(): HttpClient {
    return HttpClient {
        install(ContentNegotiation) {
            json( Json {
                ignoreUnknownKeys = true
                prettyPrint = true
                isLenient = true
            })
        }

        install(Logging) {
            logger = Logger.DEFAULT
            level = LogLevel.ALL
        }
    }
}