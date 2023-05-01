package com.rivaldy.id.core.di

import com.rivaldy.id.core.data.datasource.local.db.AppDatabase
import com.rivaldy.id.core.data.datasource.remote.ApiService
import com.rivaldy.id.core.data.repository.product.DbProductRepositoryImpl
import com.rivaldy.id.core.data.repository.product.ProductRepositoryImpl
import com.rivaldy.id.core.domain.repository.product.DbProductRepository
import com.rivaldy.id.core.domain.repository.product.ProductRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/** Created by github.com/im-o on 12/17/2022. */

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideProductRepository(apiService: ApiService): ProductRepository {
        return ProductRepositoryImpl(apiService)
    }

    @Provides
    @Singleton
    fun provideDbProductRepository(db: AppDatabase): DbProductRepository {
        return DbProductRepositoryImpl(db)
    }
}