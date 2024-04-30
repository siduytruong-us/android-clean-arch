package com.duyts.core.data.di

import com.duyts.core.data.repository.PropertyRepository
import com.duyts.core.data.repository.PropertyRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class DataModule {
    @Binds
    internal abstract fun bindsPropertyRepository(
        propertyRepository: PropertyRepositoryImpl
    ): PropertyRepository
}