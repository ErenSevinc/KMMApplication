package com.example.kmmapplication.android

import android.app.Application
import com.example.kmmapplication.android.di.appModule
import com.example.kmmapplication.di.initKoin
import org.koin.android.ext.koin.androidContext
import org.koin.core.component.KoinComponent

class KmmApp: Application(), KoinComponent {
    override fun onCreate() {
        super.onCreate()

        initKoin {
            androidContext(this@KmmApp)
            modules(appModule)
        }
    }
}