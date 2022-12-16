package com.rivaldy.id.core.data.repository

import com.rivaldy.id.core.data.model.ProductResponse
import kotlinx.coroutines.flow.Flow

/** Created by github.com/im-o on 12/16/2022. */

interface ProductRepository {
    fun fetchProductsApiCall(): Flow<Result<ProductResponse>>
}