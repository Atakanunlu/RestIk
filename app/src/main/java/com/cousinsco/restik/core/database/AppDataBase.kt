package com.cousinsco.restik.core.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.cousinsco.restik.core.database.dao.CategoryDao
import com.cousinsco.restik.core.database.entity.CategoryEntity

@Database(
    entities = [CategoryEntity::class],
    version = 1,
    exportSchema = false
)

abstract class AppDataBase : RoomDatabase() {
    abstract fun categoryDao(): CategoryDao
    companion object {
        @Volatile
        private var INSTANCE: AppDataBase? = null

        fun getDatabase(context: Context): AppDataBase {

            val tempInstance = INSTANCE
            if (tempInstance != null) {

                return tempInstance

            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDataBase::class.java,
                    "app_database_RESTIK"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }

}


