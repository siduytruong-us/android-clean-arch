package com.duyts.core.network.di

import com.duyts.core.network.AppNetworkDataSource
import com.duyts.core.network.retrofit.RetrofitAppNetwork
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
internal object NetworkModule {
    @Provides
    fun providesRetrofitAppNetwork(): AppNetworkDataSource = RetrofitAppNetwork()
}