package com.example.kmmapplication.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineScope

actual open class BaseViewModel actual constructor() : ViewModel() {

    protected actual val baseScope: CoroutineScope = viewModelScope

    public actual override fun onCleared() {
        super.onCleared()

    }
}

