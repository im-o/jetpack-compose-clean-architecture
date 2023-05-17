package id.barakkastudio.sample.ui.detail.section

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
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
import com.google.accompanist.pager.rememberPagerState
import id.barakkastudio.core.R
import id.barakkastudio.core.data.model.Product
import id.barakkastudio.core.util.Dimens

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
    Spacer(modifier = Modifier.size(Dimens.dp8))
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
    val dotRadius = 4.dp
    val dotSpacing = 8.dp

    Box(
        modifier = Modifier
            .height(dotRadius * 2)
            .fillMaxWidth()
    ) {
        Row(
            modifier = Modifier.align(Alignment.Center),
            horizontalArrangement = Arrangement.spacedBy(dotSpacing),
        ) {
            items?.forEachIndexed { index, _ ->
                Box(
                    modifier = Modifier
                        .size(dotRadius * 2)
                        .clip(CircleShape)
                        .background(
                            if (pagerState.currentPage == index) Color.Gray else Color.LightGray
                        ),
                )
            }
        }
    }
}
