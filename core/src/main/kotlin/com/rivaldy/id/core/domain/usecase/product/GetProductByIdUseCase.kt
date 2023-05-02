package com.rivaldy.id.core.domain.usecase.product

import com.rivaldy.id.core.data.model.Product
import com.rivaldy.id.core.domain.repository.product.ProductRepository
import com.rivaldy.id.core.domain.usecase.BaseUseCase
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetProductByIdUseCase @Inject constructor(
    private val productRepository: ProductRepository
) : BaseUseCase<Int, Flow<Product>>() {
    override fun execute(params: Int): Flow<Product> {
        return productRepository.getProductByIdApiCall(params)
    }
}