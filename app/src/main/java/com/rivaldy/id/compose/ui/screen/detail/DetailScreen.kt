package com.rivaldy.id.compose.ui.screen.detail

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.rivaldy.id.compose.R
import com.rivaldy.id.compose.ui.theme.Gray200
import com.rivaldy.id.compose.ui.theme.JetShopeeTheme
import com.rivaldy.id.core.data.UiState
import com.rivaldy.id.core.data.model.Product

/** Created by github.com/im-o on 12/22/2022. */

@Composable
fun DetailScreen(
    productId: Int,
    viewModel: DetailViewModel = hiltViewModel(),
    navigateBack: () -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = stringResource(R.string.detail_product))
                },
                navigationIcon = {
                    IconButton(onClick = { navigateBack() }) {
                        Icon(Icons.Filled.ArrowBack, "backIcon")
                    }
                },
                backgroundColor = MaterialTheme.colors.primary,
                contentColor = Color.White,
                elevation = 10.dp
            )
        }, content = {
            Column(
                modifier = Modifier
                    .padding(it)
                    .fillMaxSize()
                    .background(Color(0xff8d6e63)),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Gray200)
                ) {
                    viewModel.uiStateProduct.collectAsState(initial = UiState.Loading).value.let { uiState ->
                        when (uiState) {
                            is UiState.Loading -> {
                                Text(text = "Loading")
                                viewModel.getProductsApiCall(productId)
                            }
                            is UiState.Success -> {
                                DetailContent(uiState.data)
                            }
                            is UiState.Error -> {
                                Text(text = stringResource(R.string.error_product))
                            }
                        }
                    }
                }

            }
        })
}

@Composable
fun DetailContent(product: Product) {
    Text(text = "Success : $product")
}

@Preview(showBackground = true, device = Devices.PIXEL_4)
@Composable
fun DefaultPreview() {
    JetShopeeTheme {
        DetailContent(
            product = Product()
        )
    }
}