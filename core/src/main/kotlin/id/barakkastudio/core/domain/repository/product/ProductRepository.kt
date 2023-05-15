package id.barakkastudio.core.domain.repository.product

import id.barakkastudio.core.data.model.Product
import id.barakkastudio.core.data.model.ProductResponse
import kotlinx.coroutines.flow.Flow

/** Created by github.com/im-o on 12/16/2022. */

interface ProductRepository {
    fun getProductsApiCall(): Flow<ProductResponse> // this is sample not using `suspend`
    fun getProductByIdApiCall(id: Int): Flow<Product>
    suspend fun searchProductApiCall(query: String): Flow<ProductResponse> // this is sample using `suspend`
}