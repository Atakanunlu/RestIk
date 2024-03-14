package com.cousinsco.restik.core.database.repository

import com.cousinsco.restik.core.database.entity.CategoryEntity

interface CategoryRepository {
    suspend fun getAllCategoryFromRoom(): List<CategoryEntity>

    suspend fun addCategory(category: CategoryEntity)

    suspend fun updateCategory(category: CategoryEntity)

    suspend fun deleteCategory(category: CategoryEntity)


}