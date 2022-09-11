package com.example.kmmapplication.base

import kotlinx.coroutines.CoroutineScope

expect open class BaseViewModel() {

    protected val baseScope: CoroutineScope

    open fun onCleared()
}