package com.example.test.app

import android.app.Application
import com.example.test.networkModule
import com.example.test.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin



class MyApp : Application() {
    companion object {
        lateinit var instance: MyApp
    }
    override fun onCreate() {
        super.onCreate()
        instance = this
        startKoin {
            androidContext(androidContext = this@MyApp)
modules(
                listOf( networkModule,viewModelModule)
            )
        }
    }
}