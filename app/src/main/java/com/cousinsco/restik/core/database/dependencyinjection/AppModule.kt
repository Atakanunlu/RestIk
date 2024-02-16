package com.cousinsco.restik.core.database.dependencyinjection

import android.content.Context
import androidx.room.Room
import com.cousinsco.restik.core.database.AppDataBase
import com.cousinsco.restik.core.database.dao.CategoryDao
import com.cousinsco.restik.core.database.repository.CategoryRepository
import com.cousinsco.restik.core.database.repository.CategoryRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
    fun provideCategoryDb(@ApplicationContext context: Context) = Room
        .databaseBuilder(
        context,
        AppDataBase::class.java,
        "category_table"
    ).build()

    @Provides
    @Singleton
    fun provideCategoryDao(appDatabase: AppDataBase) = appDatabase.categoryDao()

    @Provides
    @Singleton
    fun provideCategoryRepository(
        categoryDao: CategoryDao
    ): CategoryRepository = CategoryRepositoryImpl(categoryDao)
}