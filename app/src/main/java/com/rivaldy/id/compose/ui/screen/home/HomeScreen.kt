package com.rivaldy.id.compose.ui.screen.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.rivaldy.id.compose.ui.components.DummyProduct
import com.rivaldy.id.compose.ui.components.ProductItem
import com.rivaldy.id.compose.ui.theme.Gray200

/** Created by github.com/im-o on 12/12/2022. */

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier
) {
    val items = DummyProduct.listProduct
    Box(modifier = modifier.background(Gray200)) {
        LazyVerticalGrid(columns = GridCells.Fixed(2), content = {
            items(items.size) { index ->
                ProductItem(
                    product = items[index], modifier = modifier.fillMaxWidth()
                )
            }
        }, contentPadding = PaddingValues(8.dp))
    }
}