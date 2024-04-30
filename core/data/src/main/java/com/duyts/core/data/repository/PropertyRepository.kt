package com.duyts.core.data.repository

import com.duyts.core.model.Property
import kotlinx.coroutines.flow.Flow

interface PropertyRepository {
    fun getProperties() : Flow<List<Property>>
    suspend fun createOne(p: Property)
}