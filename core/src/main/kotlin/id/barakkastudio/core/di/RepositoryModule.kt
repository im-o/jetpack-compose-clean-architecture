package id.barakkastudio.core.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import id.barakkastudio.core.data.datasource.local.db.AppDatabase
import id.barakkastudio.core.data.datasource.remote.ApiService
import id.barakkastudio.core.data.repository.product.DbProductRepositoryImpl
import id.barakkastudio.core.data.repository.product.ProductRepositoryImpl
import id.barakkastudio.core.domain.repository.product.DbProductRepository
import id.barakkastudio.core.domain.repository.product.ProductRepository
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