package com.dindinn.customer.common.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "CuisineItem")
data class CuisineItem(
    @PrimaryKey
    val id: Long,
    val name: String
)