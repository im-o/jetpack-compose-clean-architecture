package com.rivaldy.id.compose.ui.screen.detail.section

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.rivaldy.id.compose.R
import com.rivaldy.id.core.data.model.Product
import com.rivaldy.id.core.util.UtilFunctions.fromDollarToRupiah

/** Created by github.com/im-o on 5/12/2023. */

@Composable
fun TitleProduct(product: Product) {
    Column(
        modifier = Modifier.padding(
            horizontal = 16.dp,
            vertical = 8.dp
        )
    ) {
        Text(
            text = product.title ?: stringResource(R.string.dash),
            maxLines = 2,
            overflow = TextOverflow.Ellipsis,
            style = MaterialTheme.typography.subtitle1.copy(
                fontWeight = FontWeight.Normal, fontSize = 28.sp
            ),
            color = Color.Black
        )
        Text(
            text = product.price.fromDollarToRupiah(),
            style = MaterialTheme.typography.subtitle2.copy(
                fontWeight = FontWeight.Light, fontSize = 20.sp
            ),
            color = MaterialTheme.colors.secondary
        )
    }
}