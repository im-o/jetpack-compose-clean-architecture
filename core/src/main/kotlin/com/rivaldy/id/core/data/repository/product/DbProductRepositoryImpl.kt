package com.rivaldy.id.core.data.repository.product

import com.rivaldy.id.core.data.datasource.local.db.AppDatabase
import com.rivaldy.id.core.data.datasource.local.db.entity.ProductEntity
import com.rivaldy.id.core.domain.repository.product.DbProductRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import javax.inject.Inject

/** Created by github.com/im-o on 12/27/2022. */

class DbProductRepositoryImpl @Inject constructor(
    private val db: AppDatabase
) : DbProductRepository {

    override fun getProductsDb(): Flow<MutableList<ProductEntity>> {
        return flowOf(db.productDao().getProducts())
    }

    override fun getProductByIdDb(id: Long): Flow<ProductEntity> {
        return flowOf(db.productDao().getProductById(id))
    }

    override suspend fun insertProductDb(product: ProductEntity): Long {
        return db.productDao().insertProduct(product)
    }

    override suspend fun deleteProductDb(product: ProductEntity): Int {
        return db.productDao().deleteProduct(product)
    }
}