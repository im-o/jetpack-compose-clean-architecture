package com.rivaldy.id.compose.ui.screen.home

import androidx.compose.animation.core.tween
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.rivaldy.id.compose.R
import com.rivaldy.id.compose.ui.components.ProductItem
import com.rivaldy.id.compose.ui.components.SearchBar
import com.rivaldy.id.compose.ui.theme.Gray200
import com.rivaldy.id.core.data.UiState
import com.rivaldy.id.core.data.model.Product

/** Created by github.com/im-o on 12/12/2022. */

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    viewModel: HomeViewModel = hiltViewModel(),
    navigateToDetail: (Int) -> Unit,
) {

    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
            .fillMaxSize()
            .background(Gray200)
    ) {
        viewModel.uiStateProduct.collectAsState(initial = UiState.Loading).value.let { uiState ->
            when (uiState) {
                is UiState.Loading -> {
                    viewModel.getProductsApiCall()
                    LoadingProgress()
                }
                is UiState.Success -> {
                    HomeContent(
                        modifier = modifier,
                        listProduct = uiState.data.products,
                        navigateToDetail = navigateToDetail,
                        viewModel = viewModel
                    )
                }
                is UiState.Error -> {
                    Text(text = stringResource(R.string.error_product))
                }
            }
        }
    }
}

@Composable
fun LoadingProgress() {
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
            text = stringResource(R.string.load_product),
            color = MaterialTheme.colors.onSurface
        )
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
private fun HomeContent(
    modifier: Modifier,
    listProduct: MutableList<Product>?,
    navigateToDetail: (Int) -> Unit,
    viewModel: HomeViewModel
) {
    val query by viewModel.query
    Column(
        modifier = modifier.fillMaxSize()
    ) {
        SearchBar(
            query = query,
            onQueryChange = viewModel::searchProductApiCall,
            modifier = Modifier.background(MaterialTheme.colors.primary)
        )
        if (listProduct != null) {
            LazyVerticalGrid(
                columns = GridCells.Adaptive(140.dp),
                content = {
                    items(listProduct, key = { it.id ?: -1 }) { product ->
                        ProductItem(
                            product = product,
                            modifier = modifier
                                .fillMaxWidth()
                                .animateItemPlacement(tween(durationMillis = 100))
                                .clickable {
                                    navigateToDetail(product.id ?: return@clickable)
                                }
                        )
                    }
                }, contentPadding = PaddingValues(8.dp)
            )
            if (listProduct.isEmpty()) EmptyProduct()
        } else EmptyProduct()
    }
}

@Composable
fun EmptyProduct() {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        Text(
            text = stringResource(R.string.no_product),
            color = MaterialTheme.colors.onSurface,
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentWidth(Alignment.CenterHorizontally)
        )
    }
}