package com.duyts.core.database.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.duyts.core.model.Property

@Entity(tableName = "property")
data class PropertyEntity(
    @PrimaryKey(autoGenerate = true)
    var uid: Int? = 0,
    val title: String,
)

fun PropertyEntity.toModel() = Property(
    id = this.uid,
    title = this.title,
)