package com.duyts.core.database.di

import com.duyts.core.database.AppDatabase
import com.duyts.core.database.source.PropertyDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
internal object DaoModule {
    @Provides
    fun providesPropertyDao(database: AppDatabase): PropertyDao = database.propertyDao()
}