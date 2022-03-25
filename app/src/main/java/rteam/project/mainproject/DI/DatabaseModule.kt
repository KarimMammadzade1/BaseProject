package rteam.project.mainproject.DI

import android.app.Application
import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import rteam.project.mainproject.Helpers.Constants
import rteam.project.mainproject.RoomDatabase.RoomDatabase
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Singleton
    @Provides
    fun getDatabase(@ApplicationContext context: Context) =RoomDatabase.getDatabase(context as Application)

    @Singleton
    @Provides
    fun getDao(db: RoomDatabase) = db.roomDataAccessObject()

    @Singleton
    @Provides
    fun getApplicationContext(@ApplicationContext context: Context) = context

}