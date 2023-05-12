package com.rivaldy.id.compose.ui.screen.detail.section

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Tab
import androidx.compose.material.TabRow
import androidx.compose.material.TabRowDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import coil.compose.SubcomposeAsyncImage
import coil.request.ImageRequest
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.PagerState
import com.google.accompanist.pager.pagerTabIndicatorOffset
import com.google.accompanist.pager.rememberPagerState
import com.rivaldy.id.compose.R
import com.rivaldy.id.core.data.model.Product

/** Created by github.com/im-o on 5/12/2023. */

@OptIn(ExperimentalPagerApi::class)
@Composable
fun ImageProductPager(product: Product) {
    val items = product.images
    val pagerState = rememberPagerState()

    HorizontalPager(
        count = items?.size ?: 0,
        state = pagerState
    ) { page ->
        SubcomposeAsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data(items?.get(page))
                .crossfade(true)
                .build(),
            loading = {
                CircularProgressIndicator(
                    color = Color.LightGray,
                    modifier = Modifier.padding(48.dp)
                )
            },
            contentDescription = stringResource(R.string.product_thumbnail),
            contentScale = ContentScale.Fit,
            modifier = Modifier.height(260.dp)
        )
    }

    HorizontalTabs(
        items = items ?: emptyList<String>(),
        pagerState = pagerState
    )
}

@OptIn(ExperimentalPagerApi::class)
@Composable
private fun HorizontalTabs(
    items: List<String?>?,
    pagerState: PagerState,
) {
    TabRow(
        modifier = Modifier.height(1.dp),
        backgroundColor = Color.White,
        divider = {},
        selectedTabIndex = pagerState.currentPage,
        indicator = { tabPositions ->
            TabRowDefaults.Indicator(
                modifier = Modifier.pagerTabIndicatorOffset(pagerState, tabPositions)
            )
        }
    ) {
        items?.forEachIndexed { index, _ ->
            Tab(
                selected = pagerState.currentPage == index,
                onClick = { }
            )
        }
    }
}
