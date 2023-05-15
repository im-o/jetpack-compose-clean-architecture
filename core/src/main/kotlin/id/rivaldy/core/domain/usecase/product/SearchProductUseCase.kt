package id.rivaldy.core.domain.usecase.product

import id.rivaldy.core.data.model.ProductResponse
import id.rivaldy.core.domain.repository.product.ProductRepository
import id.rivaldy.core.domain.usecase.BaseUseCaseSuspend
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class SearchProductUseCase @Inject constructor(
    private val productRepository: ProductRepository
) : BaseUseCaseSuspend<String, Flow<ProductResponse>>() {
    override suspend fun execute(params: String): Flow<ProductResponse> {
        return productRepository.searchProductApiCall(params)
    }
}