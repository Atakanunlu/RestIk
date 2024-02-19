package com.cousinsco.restik.core.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.cousinsco.restik.core.database.entity.CategoryEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface CategoryDao {

    @Query("SELECT * FROM category_table")
    fun getAllCategories(): Flow<List<CategoryEntity>>
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(category: CategoryEntity)
    @Update
    fun update(category: CategoryEntity)

    @Delete
    fun delete(category: CategoryEntity)

    @Delete
    fun deleteAll(category: CategoryEntity)



}