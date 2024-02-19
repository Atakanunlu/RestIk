package com.cousinsco.restik.core.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "category_table")
data class CategoryEntity(
    @PrimaryKey(autoGenerate = true) val categoryId: Int?,
    @ColumnInfo(name = "category_name") val categoryName: String?
    //@ColumnInfo(name = "category_image") val categoryIamge: String?
)