package com.duyts.core.data.repository

import com.duyts.core.data.model.asEntity
import com.duyts.core.database.model.PropertyEntity
import com.duyts.core.database.model.toModel
import com.duyts.core.database.source.PropertyDao
import com.duyts.core.model.Property
import com.duyts.core.network.AppNetworkDataSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject


internal class PropertyRepositoryImpl @Inject constructor(
    private val propertyDao: PropertyDao,
    private val network: AppNetworkDataSource,
) : PropertyRepository {
    override fun getProperties(): Flow<List<Property>> =
        propertyDao.getProperties().map { it.map(PropertyEntity::toModel) }

    override suspend fun createOne(p: Property) {
        propertyDao.insertOne(p.asEntity())
    }
}