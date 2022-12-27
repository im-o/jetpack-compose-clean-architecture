package com.rivaldy.id.core.data.datasource.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.rivaldy.id.core.data.datasource.local.db.dao.ProductDao
import com.rivaldy.id.core.data.datasource.local.db.entity.ProductEntity

/** Created by github.com/im-o on 12/27/2022. */

@Database(
    entities = [ProductEntity::class],
    version = 1,
    exportSchema = false
)

abstract class AppDatabase : RoomDatabase() {
    abstract fun productDao(): ProductDao
}