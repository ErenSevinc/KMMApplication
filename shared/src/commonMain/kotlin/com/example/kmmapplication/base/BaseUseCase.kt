package com.example.kmmapplication.base

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn

/***
 * I(Input): Request Body Type
 * O(Output): Response Body Type
 */
abstract class BaseUseCase<in I, O> constructor(private val dispatcher: CoroutineDispatcher = BaseDispatcher) {

    protected abstract fun buildUseCase(params: I): Flow<O>

    fun invoke(params: I): Flow<O> = buildUseCase(params).flowOn(dispatcher)
}