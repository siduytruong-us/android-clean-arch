package com.duyts.core.data.model

import com.duyts.core.database.model.PropertyEntity
import com.duyts.core.model.Property
import com.duyts.core.network.model.PropertyResponse


internal fun PropertyResponse.asEntity() = PropertyEntity(uid = id, title = title)

internal fun PropertyResponse.asModel() = Property(id = id, title = title)

internal fun Property.asEntity() = PropertyEntity(uid = this.id, title = this.title)