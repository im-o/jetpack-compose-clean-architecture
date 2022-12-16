package com.rivaldy.id.core.data.repository

import androidx.annotation.WorkerThread
import com.rivaldy.id.core.data.datasource.remote.ApiService
import com.rivaldy.id.core.data.model.ProductResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

/** Created by github.com/im-o on 12/16/2022. */

class ProductRepositoryImpl @Inject constructor(
    private val apiService: ApiService
) : ProductRepository {

    @WorkerThread
    override fun fetchProductsApiCall(): Flow<Result<ProductResponse>> = flow {
        try {
            val response = apiService.fetchProducts()
            emit(Result.success(response))
        } catch (e: Exception) {
            emit(Result.failure(e))
        }
    }.flowOn(Dispatchers.IO)
}