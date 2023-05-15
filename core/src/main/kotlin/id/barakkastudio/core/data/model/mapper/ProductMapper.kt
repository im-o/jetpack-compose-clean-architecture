package id.barakkastudio.core.data.model.mapper

import id.barakkastudio.core.data.datasource.local.db.entity.ProductEntity
import id.barakkastudio.core.data.model.Product

/** Created by github.com/im-o on 12/27/2022. */

object ProductMapper {
    fun mapFromProductToEntity(product: Product) =
        ProductEntity(product.id, product.description, product.price, product.thumbnail, product.title)
}