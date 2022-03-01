package rteam.project.mainproject.RoomDatabase

import android.app.Application
import android.content.Context
import androidx.room.Database
import androidx.room.Room

@Database(entities = [EntityModel::class], version = 1, exportSchema = false)
abstract class RoomDatabase : androidx.room.RoomDatabase() {
    abstract fun roomDataAccessObject(): RoomDataAccesObject

    companion object {
        @Volatile
        private var INSTANCE: RoomDatabase? = null
        fun getDatabase(application: Application): RoomDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    application,
                    RoomDatabase::class.java, "project_database"
                )
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build()
                INSTANCE = instance
                return instance
            }
        }

    }

}