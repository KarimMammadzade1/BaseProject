package rteam.project.mainproject.RoomDatabase

import androidx.room.Entity
import androidx.room.PrimaryKey
@Entity(tableName = "TestTable")
data class EntityModel(
    @PrimaryKey
    val testField: String
)