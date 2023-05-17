package id.rivaldy.sample.ui.screen.cart.section

import androidx.compose.animation.core.tween
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import id.rivaldy.sample.ui.component.EmptyProduct
import id.rivaldy.sample.ui.component.ProductCartItem
import id.rivaldy.sample.ui.screen.cart.CartViewModel
import id.rivaldy.core.R
import id.rivaldy.core.data.datasource.local.db.entity.ProductEntity
import id.rivaldy.core.util.Extensions.myToast

/** Created by github.com/im-o on 5/12/2023. */

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun CartContent(
    products: MutableList<ProductEntity>,
    navigateToDetail: (Int) -> Unit,
    viewModel: CartViewModel
) {
    val context = LocalContext.current

    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        content = {
            items(products, key = { it.id ?: -1 }) { product ->
                val strRemoveCart = stringResource(id = R.string.remove_from_cart_, product.title.toString())
                ProductCartItem(
                    modifier = Modifier
                        .fillMaxWidth()
                        .animateItemPlacement(tween(durationMillis = 100))
                        .clickable {
                            navigateToDetail(product.id ?: return@clickable)
                        },
                    product = product,
                    onRemoveClicked = {
                        viewModel.deleteProductDb(product)
                        context.myToast(strRemoveCart)
                    }
                )
            }
        }, contentPadding = PaddingValues(8.dp)
    )
    if (products.isEmpty()) EmptyProduct()
}