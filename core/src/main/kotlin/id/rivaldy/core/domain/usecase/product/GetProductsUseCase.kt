package id.rivaldy.core.domain.usecase.product

import id.rivaldy.core.data.model.ProductResponse
import id.rivaldy.core.domain.repository.product.ProductRepository
import id.rivaldy.core.domain.usecase.BaseUseCase
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetProductsUseCase @Inject constructor(
    private val productRepository: ProductRepository
) : BaseUseCase<Unit, Flow<ProductResponse>>() {
    override fun execute(params: Unit): Flow<ProductResponse> {
        return productRepository.getProductsApiCall()
    }
}