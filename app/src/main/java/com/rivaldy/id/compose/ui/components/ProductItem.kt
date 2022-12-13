package com.rivaldy.id.compose.ui.components


import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.rivaldy.id.compose.ui.theme.Gray100
import com.rivaldy.id.compose.ui.theme.Shapes
import com.rivaldy.id.core.data.model.ProductResponse

@Composable
fun ProductItem(
    product: ProductResponse,
    modifier: Modifier
) {
    Card(
        shape = RoundedCornerShape(8.dp),
        backgroundColor = Color.White,
        modifier = modifier
            .padding(8.dp)
            .defaultMinSize()
            .clip(Shapes.medium)
    ) {
        Column(
            modifier = modifier.defaultMinSize()
        ) {
            AsyncImage(
                model = product.thumbnail,
                contentDescription = "product_image",
                contentScale = ContentScale.Crop,
                modifier = modifier
                    .height(180.dp)
                    .clip(Shapes.medium)
            )
            Divider(color = Gray100, thickness = 1.dp)
            Column(
                modifier = modifier.padding(horizontal = 16.dp, vertical = 8.dp)
            ) {
                Text(
                    text = product.title ?: "",
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis,
                    style = MaterialTheme.typography.subtitle1.copy(
                        fontWeight = FontWeight.ExtraBold
                    )
                )
                Text(
                    text = "${product.price}",
                    style = MaterialTheme.typography.subtitle2,
                    color = MaterialTheme.colors.secondary
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ProductItemPreview() {
    ProductItem(
        product = ProductResponse(
            id = 1,
            title = "Product Title",
            price = 100000,
            thumbnail = "https://www.google.com/images/branding/googlelogo/2x/googlelogo_color_272x92dp.png"
        ),
        modifier = Modifier
    )
}