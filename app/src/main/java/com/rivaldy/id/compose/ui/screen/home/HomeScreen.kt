package com.rivaldy.id.compose.ui.screen.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.rivaldy.id.compose.R
import com.rivaldy.id.compose.ui.components.ProductItem
import com.rivaldy.id.compose.ui.theme.Gray200
import com.rivaldy.id.core.data.UiState
import com.rivaldy.id.core.data.model.Product
import com.rivaldy.id.core.data.model.ProductResponse

/** Created by github.com/im-o on 12/12/2022. */

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    viewModel: HomeViewModel = hiltViewModel()
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
                    viewModel.fetchProductsApiCall()
                    ShowLoading(modifier)
                }
                is UiState.Success -> {
                    ShowProduct(modifier, uiState)
                }
                is UiState.Error -> {
                    Text(text = stringResource(R.string.error_product))
                }
            }
        }
    }
}

@Composable
fun ShowLoading(modifier: Modifier) {
    Column {
        CircularProgressIndicator(
            modifier = modifier
                .fillMaxWidth()
                .wrapContentWidth(Alignment.CenterHorizontally)
        )
        Spacer(modifier = Modifier.size(32.dp))
        Text(
            modifier = modifier
                .fillMaxWidth()
                .wrapContentWidth(Alignment.CenterHorizontally),
            text = stringResource(R.string.load_product)
        )
    }
}

@Composable
fun ShowProduct(modifier: Modifier, uiState: UiState.Success<ProductResponse>) {
    val listProduct = uiState.data.products
    if (listProduct != null) LazyVerticalGrid(columns = GridCells.Fixed(2), content = {
        items(listProduct.size) { index ->
            ProductItem(
                product = listProduct[index] ?: Product(),
                modifier = modifier.fillMaxWidth()
            )
        }
    }, contentPadding = PaddingValues(8.dp))
    else Text(text = stringResource(R.string.no_product))
}