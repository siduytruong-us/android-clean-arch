package com.duyts.core.database.source

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.duyts.core.database.model.PropertyEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface PropertyDao {

    @Query("SELECT * FROM property ORDER BY uid DESC LIMIT 10")
    fun getProperties(): Flow<List<PropertyEntity>>

    @Insert
    suspend fun insertOne(item: PropertyEntity)
}