package com.cousinsco.restik.ui.menumanagement.menu

sealed class CategoryEvent {
    data class CategoryAdd(val categoryName : String) : CategoryEvent()
    data object ListCategories : CategoryEvent()

    //data class DeleteCategory(category:) :  CategoryEvent()
}