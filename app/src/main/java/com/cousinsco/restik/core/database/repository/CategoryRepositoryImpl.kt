package com.cousinsco.restik.core.database.repository

import com.cousinsco.restik.core.database.dao.CategoryDao
import com.cousinsco.restik.core.database.entity.CategoryEntity



class CategoryRepositoryImpl (private val categoryDao: CategoryDao): CategoryRepository {
    override suspend fun getAllCategoryFromRoom(): List<CategoryEntity> = categoryDao.getAllCategories()

    override suspend fun addCategory(category: CategoryEntity) = categoryDao.insert(category)

    override suspend fun updateCategory(category: CategoryEntity) = categoryDao.update(category)

    override suspend fun deleteCategory(category: CategoryEntity) = categoryDao.delete(category)


}

