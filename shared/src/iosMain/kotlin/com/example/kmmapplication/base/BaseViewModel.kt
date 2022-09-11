package com.example.kmmapplication.base

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.cancel
import platform.darwin.dispatch_async
import platform.darwin.dispatch_get_main_queue
import kotlin.native.internal.GC

actual open class BaseViewModel actual constructor() {

    protected actual val baseScope: CoroutineScope = createViewModelScope()

    actual open fun onCleared() {
        baseScope.cancel()

        dispatch_async(dispatch_get_main_queue()) { GC.collect() }
    }
}

@ThreadLocal
private var createViewModelScope: () -> CoroutineScope = {
    CoroutineScope(BaseDispatcher)
}