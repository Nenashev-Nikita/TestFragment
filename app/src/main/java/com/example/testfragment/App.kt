package com.example.testfragment

import android.app.Application
import com.example.testfragment.di.appModule
import com.example.testfragment.features.exercises.di.exercisesModule
import com.example.testfragment.network.di.networkModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class App : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@App)
            androidLogger(Level.DEBUG)
            modules(
                appModule,
                networkModule,
                exercisesModule,
            )
        }
    }
}