package com.rivaldy.id.core.util

import com.rivaldy.id.core.data.model.Product
import com.rivaldy.id.core.data.model.ProductResponse

/** Created by github.com/im-o on 5/3/2023. */

object UtilTests {
    val dummyProduct = Product("Product", "Product 1")
    val dummyProductResponse = ProductResponse(0, mutableListOf(dummyProduct))
}