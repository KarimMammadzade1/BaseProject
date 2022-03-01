package rteam.project.mainproject.RoomDatabase

import androidx.room.Dao
import androidx.room.Insert

@Dao
interface RoomDataAccesObject {
    @Insert()
    suspend fun insertData(testData: EntityModel)
}
