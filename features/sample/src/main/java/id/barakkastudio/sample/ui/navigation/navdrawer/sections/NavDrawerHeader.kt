package id.barakkastudio.sample.ui.navigation.navdrawer.sections

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import id.barakkastudio.core.R
import id.barakkastudio.core.util.Dimens

/** Created by github.com/im-o on 11/16/2023. */

@Composable
fun NavDrawerHeader(
    modifier: Modifier = Modifier,
) {
    Row {
        Image(
            modifier = modifier
                .size(Dimens.dp60)
                .shadow(elevation = Dimens.dp1, shape = CircleShape)
                .clip(shape = CircleShape),
            painter = painterResource(id = R.drawable.rival_profile),
            contentDescription = stringResource(id = R.string.rivaldy),
            contentScale = ContentScale.Crop,
        )
        Spacer(modifier = modifier.width(Dimens.dp16))
        Column(modifier = modifier.align(Alignment.CenterVertically)) {
            Text(
                text = stringResource(id = R.string.rivaldy),
                style = TextStyle(
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                    fontSize = Dimens.sp18,
                ),
            )
            Spacer(modifier = modifier.height(Dimens.dp3))
            Text(
                text = stringResource(id = R.string.profile_web),
                style = TextStyle(
                    fontWeight = FontWeight.Bold,
                    color = Color.White.copy(alpha = 0.5f),
                    fontSize = Dimens.sp14,
                ),
            )
        }
    }
}