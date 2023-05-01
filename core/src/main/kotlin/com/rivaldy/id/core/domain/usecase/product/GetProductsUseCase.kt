package com.rivaldy.id.core.domain.usecase.product

import com.rivaldy.id.core.data.model.ProductResponse
import com.rivaldy.id.core.domain.repository.product.ProductRepository
import com.rivaldy.id.core.domain.usecase.BaseUseCase
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetProductsUseCase @Inject constructor(
    private val productRepository: ProductRepository
) : BaseUseCase<Unit, Flow<ProductResponse>>() {
    override fun execute(params: Unit): Flow<ProductResponse> {
        return productRepository.getProductsApiCall()
    }
}