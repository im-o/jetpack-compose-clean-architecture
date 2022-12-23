package com.rivaldy.id.core.data.repository

import com.rivaldy.id.core.data.datasource.remote.ApiService
import com.rivaldy.id.core.data.model.Product
import com.rivaldy.id.core.data.model.ProductResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import javax.inject.Inject

/** Created by github.com/im-o on 12/16/2022. */

class ProductRepositoryImpl @Inject constructor(
    private val apiService: ApiService
) : ProductRepository {

    override suspend fun getProductsApiCall(): Flow<ProductResponse> {
        return flowOf(apiService.getProducts())
    }

    override suspend fun getProductByIdApiCall(id: Int): Flow<Product> {
        return flowOf(apiService.getProductById(id))
    }
}