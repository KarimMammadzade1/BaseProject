package rteam.project.mainproject.KoinModules

import android.app.Application
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module
import rteam.project.mainproject.RoomDatabase.RoomDatabase

val roomModule = module {fun provideDatabase(application: Application) = RoomDatabase.getDatabase(application)
    fun provideRoomDao (roomDatabase: RoomDatabase) = roomDatabase.roomDataAccessObject()
    single { provideDatabase(androidApplication()) }
    single { provideRoomDao(get()) }
}