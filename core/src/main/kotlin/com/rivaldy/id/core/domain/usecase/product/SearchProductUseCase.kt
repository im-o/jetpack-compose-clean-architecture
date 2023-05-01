package com.rivaldy.id.core.domain.usecase.product

import com.rivaldy.id.core.data.model.ProductResponse
import com.rivaldy.id.core.domain.repository.product.ProductRepository
import com.rivaldy.id.core.domain.usecase.BaseUseCaseSuspend
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class SearchProductUseCase @Inject constructor(
    private val productRepository: ProductRepository
) : BaseUseCaseSuspend<String, Flow<ProductResponse>>() {
    override suspend fun execute(params: String): Flow<ProductResponse> {
        return productRepository.searchProductApiCall(params)
    }
}