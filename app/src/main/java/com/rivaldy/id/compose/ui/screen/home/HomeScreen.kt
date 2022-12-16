package com.rivaldy.id.compose.ui.screen.home

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.rivaldy.id.compose.ui.components.ProductItem
import com.rivaldy.id.compose.ui.theme.Gray200
import kotlinx.coroutines.launch

/** Created by github.com/im-o on 12/12/2022. */

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    viewModel: HomeViewModel = hiltViewModel()
) {
    val coroutineScope = rememberCoroutineScope()
    Box(modifier = modifier.background(Gray200)) {
        LazyVerticalGrid(columns = GridCells.Fixed(2), content = {
            coroutineScope.launch {
                viewModel.fetchProductsApiCall().collect { result ->
                    result.onSuccess {
                        Log.e("IMO", "HomeScreen onSuccess: $it")
                        val items = it.products
                        items(items?.size ?: return@onSuccess) { index ->
                            ProductItem(
                                product = items[index] ?: return@items, modifier = modifier.fillMaxWidth()
                            )
                        }
                    }
                    result.onFailure {
                        Log.e("IMO", "HomeScreen onFailure: $it")
                    }
                }
            }
        }, contentPadding = PaddingValues(8.dp))
    }
}