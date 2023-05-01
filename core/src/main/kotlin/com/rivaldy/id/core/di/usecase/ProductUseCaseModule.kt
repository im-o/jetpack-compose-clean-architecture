package com.rivaldy.id.core.di.usecase

import com.rivaldy.id.core.domain.repository.product.ProductRepository
import com.rivaldy.id.core.domain.usecase.product.GetProductsUseCase
import com.rivaldy.id.core.domain.usecase.product.SearchProductUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

/** Created by github.com/im-o on 5/1/2023. */

@Module
@InstallIn(ViewModelComponent::class)
object ProductUseCaseModule {

    @Provides
    fun provideGetProductUseCase(productRepository: ProductRepository): GetProductsUseCase {
        return GetProductsUseCase(productRepository)
    }

    @Provides
    fun provideSearchProductUseCase(productRepository: ProductRepository): SearchProductUseCase {
        return SearchProductUseCase(productRepository)
    }
}