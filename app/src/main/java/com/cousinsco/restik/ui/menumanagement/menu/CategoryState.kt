package com.cousinsco.restik.ui.menumanagement.menu

import com.cousinsco.restik.core.database.entity.CategoryEntity

data class CategoryState(
    val isLoading: Boolean = false,
    val error: String = "",
    val categories: List<CategoryEntity>? = emptyList(),
    val newCategory: String = "",
    val selectedCategory: CategoryEntity? = null

    )
