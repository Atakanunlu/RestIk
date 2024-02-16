package com.cousinsco.restik.ui.menumanagement.menu

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cousinsco.restik.core.database.entity.CategoryEntity
import com.cousinsco.restik.core.database.repository.CategoryRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class MenuViewModel @Inject constructor(private val repo:CategoryRepository): ViewModel(){

    fun addCategory(category:CategoryEntity) = viewModelScope.launch(Dispatchers.IO){
        repo.addCategory(category)
    }
    fun updateCategory(category:CategoryEntity) = viewModelScope.launch(Dispatchers.IO){
        repo.updateCategory(category)
    }
    fun deleteCategory(category: CategoryEntity) = viewModelScope.launch(Dispatchers.IO){
        repo.deleteCategory(category)
    }

}
