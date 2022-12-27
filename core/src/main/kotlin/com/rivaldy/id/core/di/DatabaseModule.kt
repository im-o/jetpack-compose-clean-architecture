package com.rivaldy.id.core.di

import android.content.Context
import androidx.room.Room
import com.rivaldy.id.core.data.datasource.local.db.AppDatabase
import com.rivaldy.id.core.util.UtilConstants.DB_JET_SHOPEE
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/** Created by github.com/im-o on 12/27/2022. */

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext context: Context): AppDatabase {
        return Room.databaseBuilder(context, AppDatabase::class.java, DB_JET_SHOPEE).build()
    }
}