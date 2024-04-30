package com.duyts.core.network

import com.duyts.core.network.model.PropertyResponse

interface AppNetworkDataSource {
    suspend fun getProperties() : List<PropertyResponse>
}