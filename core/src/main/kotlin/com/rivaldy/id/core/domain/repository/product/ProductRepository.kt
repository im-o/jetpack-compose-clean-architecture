package com.rivaldy.id.core.domain.repository.product

import com.rivaldy.id.core.data.model.Product
import com.rivaldy.id.core.data.model.ProductResponse
import kotlinx.coroutines.flow.Flow

/** Created by github.com/im-o on 12/16/2022. */

interface ProductRepository {
    suspend fun getProductsApiCall(): Flow<ProductResponse>
    suspend fun searchProductApiCall(query: String): Flow<ProductResponse>
    suspend fun getProductByIdApiCall(id: Int): Flow<Product>
}