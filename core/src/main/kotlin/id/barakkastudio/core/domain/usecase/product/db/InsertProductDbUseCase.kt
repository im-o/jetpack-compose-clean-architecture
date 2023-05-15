package id.barakkastudio.core.domain.usecase.product.db

import id.barakkastudio.core.data.datasource.local.db.entity.ProductEntity
import id.barakkastudio.core.domain.repository.product.DbProductRepository
import id.barakkastudio.core.domain.usecase.BaseUseCaseSuspend
import javax.inject.Inject

/** Created by github.com/im-o on 5/2/2023. */

class InsertProductDbUseCase @Inject constructor(
    private val dbProductRepository: DbProductRepository
) : BaseUseCaseSuspend<ProductEntity, Long>() {
    override suspend fun execute(params: ProductEntity): Long {
        return dbProductRepository.insertProductDb(params)
    }
}