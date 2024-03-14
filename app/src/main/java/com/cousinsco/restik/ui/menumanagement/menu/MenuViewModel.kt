package com.cousinsco.restik.ui.menumanagement.menu


import androidx.compose.runtime.MutableState

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cousinsco.restik.components.Resource
import com.cousinsco.restik.usecase.AddCategoryUseCase
import com.cousinsco.restik.usecase.GetCategoryUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class MenuViewModel @Inject constructor(private val addCategoryUseCase: AddCategoryUseCase,
                                        private val getCategoryUseCase: GetCategoryUseCase): ViewModel(){

    private val _categoriesState = mutableStateOf(CategoryState())
    val categoriesState: MutableState<CategoryState> = _categoriesState


    fun onEvent(event : CategoryEvent){
        when(event){
            is CategoryEvent.CategoryAdd -> {
                viewModelScope.launch(Dispatchers.IO) {
                    addCategoryUseCase(event.categoryName).collect()
                    onEvent(CategoryEvent.ListCategories)
                }

            }
            CategoryEvent.ListCategories -> {
                viewModelScope.launch(Dispatchers.IO) {
                  getCategoryUseCase().onEach {
                   when(it){
                       is Resource.Error -> _categoriesState.value = _categoriesState.value.copy(isLoading = false,error = "Kategori listelenirken hata oluştu.")
                       is Resource.Loading -> _categoriesState.value = _categoriesState.value.copy(isLoading = true)
                       is Resource.Success -> _categoriesState.value = _categoriesState.value.copy(isLoading = false, categories = it.data)
                   }
                  }.collect()
                }
            }
        }
    }


}




