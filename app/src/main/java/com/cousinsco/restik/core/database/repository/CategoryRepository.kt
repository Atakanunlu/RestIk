package com.cousinsco.restik.core.database.repository

import com.cousinsco.restik.core.database.entity.CategoryEntity
import kotlinx.coroutines.flow.Flow

interface CategoryRepository {
    suspend fun getAllCategoryFromRoom(): Flow<List<CategoryEntity>>

    suspend fun addCategory(category: CategoryEntity)

    suspend fun updateCategory(category: CategoryEntity)

    suspend fun deleteCategory(category: CategoryEntity)


}