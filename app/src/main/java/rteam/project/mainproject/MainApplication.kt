package rteam.project.mainproject

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level
import rteam.project.mainproject.KoinModules.retrofitModule
import rteam.project.mainproject.KoinModules.roomModule


class MainApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger(Level.INFO)
            androidContext(this@MainApplication)
            modules(listOf( roomModule, retrofitModule))

        }
    }

}