package id.barakkastudio.core.domain.usecase.product.db

import id.barakkastudio.core.data.datasource.local.db.entity.ProductEntity
import id.barakkastudio.core.domain.repository.product.DbProductRepository
import id.barakkastudio.core.domain.usecase.BaseUseCase
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/** Created by github.com/im-o on 5/2/2023. */

class GetProductsDbUseCase @Inject constructor(
    private val dbProductRepository: DbProductRepository
) : BaseUseCase<Unit, Flow<MutableList<ProductEntity>>>() {
    override fun execute(params: Unit): Flow<MutableList<ProductEntity>> {
        return dbProductRepository.getProductsDb()
    }
}