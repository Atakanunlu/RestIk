package com.cousinsco.restik.usecase

import com.cousinsco.restik.components.Resource
import com.cousinsco.restik.core.database.entity.CategoryEntity
import com.cousinsco.restik.core.database.repository.CategoryRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class AddCategoryUseCase @Inject constructor(private val repo: CategoryRepository){
    suspend operator fun invoke(categoryName:String): Flow<Resource<Boolean>> = flow{
        emit(Resource.Loading(true))
       repo.addCategory(CategoryEntity(categoryName = categoryName))
    }
}