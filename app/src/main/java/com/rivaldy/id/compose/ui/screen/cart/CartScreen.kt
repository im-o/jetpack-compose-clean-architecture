package com.rivaldy.id.compose.ui.screen.cart

import android.widget.Toast
import androidx.compose.animation.core.tween
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.rivaldy.id.compose.R
import com.rivaldy.id.compose.ui.components.ProductCartItem
import com.rivaldy.id.compose.ui.screen.home.EmptyProduct
import com.rivaldy.id.compose.ui.theme.Gray200
import com.rivaldy.id.core.data.UiState
import com.rivaldy.id.core.data.datasource.local.db.entity.ProductEntity

/** Created by github.com/im-o on 12/12/2022. */

@Composable
fun CartScreen(
    viewModel: CartViewModel = hiltViewModel(),
    navigateToDetail: (Int) -> Unit,
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = stringResource(R.string.cart))
                },
                backgroundColor = MaterialTheme.colors.primary,
                contentColor = Color.White,
                elevation = 0.dp
            )
        }, content = {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .fillMaxSize()
                    .background(Gray200)
                    .padding(it)
            ) {
                viewModel.uiStateDbProducts.collectAsState(initial = UiState.Loading).value.let { uiState ->
                    when (uiState) {
                        is UiState.Loading -> {
                            LoadingProgress()
                            viewModel.getProductsDb()
                        }
                        is UiState.Success -> {
                            CartContent(products = uiState.data, viewModel = viewModel, navigateToDetail = navigateToDetail)
                        }
                        is UiState.Error -> {
                            Text(text = stringResource(R.string.error_product))
                        }
                    }
                }
            }
        })

}

@Composable
private fun LoadingProgress() {
    Column {
        CircularProgressIndicator(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentWidth(Alignment.CenterHorizontally)
        )
        Spacer(modifier = Modifier.size(32.dp))
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentWidth(Alignment.CenterHorizontally),
            text = stringResource(R.string.load_product)
        )
    }
}

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
                        Toast
                            .makeText(context, strRemoveCart, Toast.LENGTH_SHORT)
                            .show()
                    }
                )
            }
        }, contentPadding = PaddingValues(8.dp)
    )
    if (products.isEmpty()) EmptyProduct()
}
