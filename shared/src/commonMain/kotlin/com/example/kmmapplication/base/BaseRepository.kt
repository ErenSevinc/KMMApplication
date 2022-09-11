package com.example.kmmapplication.base

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.FlowCollector
import kotlinx.coroutines.flow.flow

open class BaseRepository {

    protected fun <T> fetch(apiCall: suspend () -> T): Flow<T> {
        return flow {
            val response = apiCall()
            emit(response)
        }
    }
}