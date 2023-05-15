package id.barakkastudio.core.domain.usecase.product.db

import id.barakkastudio.core.data.datasource.local.db.entity.ProductEntity
import id.barakkastudio.core.domain.repository.product.DbProductRepository
import id.barakkastudio.core.domain.usecase.BaseUseCaseSuspend
import javax.inject.Inject

/** Created by github.com/im-o on 5/2/2023. */

class DeleteProductDbUseCase @Inject constructor(
    private val dbProductRepository: DbProductRepository
) : BaseUseCaseSuspend<ProductEntity, Int>() {
    override suspend fun execute(params: ProductEntity): Int {
        return dbProductRepository.deleteProductDb(params)
    }
}