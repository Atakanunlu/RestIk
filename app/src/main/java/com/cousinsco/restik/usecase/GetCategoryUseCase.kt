package com.cousinsco.restik.usecase

import com.cousinsco.restik.components.Resource
import com.cousinsco.restik.core.database.entity.CategoryEntity
import com.cousinsco.restik.core.database.repository.CategoryRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetCategoryUseCase @Inject constructor(private val repo: CategoryRepository) {
    suspend operator fun invoke(): Flow<Resource<List<CategoryEntity>>> = flow{
        emit(Resource.Loading())
   try {
        val listCategory = repo.getAllCategoryFromRoom()
         emit(Resource.Success(listCategory))
    }catch (e: Exception){
        emit(Resource.Error(message = "Kategori listesi oluşturulurken hata oluştu."))
        }
    }
}