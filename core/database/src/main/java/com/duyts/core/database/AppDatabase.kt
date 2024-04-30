package com.duyts.core.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.duyts.core.database.model.PropertyEntity
import com.duyts.core.database.source.PropertyDao


@Database(entities = [PropertyEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun propertyDao(): PropertyDao
}