package id.barakkastudio.core.domain.usecase.product

import id.barakkastudio.core.data.model.ProductResponse
import id.barakkastudio.core.domain.repository.product.ProductRepository
import id.barakkastudio.core.domain.usecase.BaseUseCaseSuspend
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class SearchProductUseCase @Inject constructor(
    private val productRepository: ProductRepository
) : BaseUseCaseSuspend<String, Flow<ProductResponse>>() {
    override suspend fun execute(params: String): Flow<ProductResponse> {
        return productRepository.searchProductApiCall(params)
    }
}