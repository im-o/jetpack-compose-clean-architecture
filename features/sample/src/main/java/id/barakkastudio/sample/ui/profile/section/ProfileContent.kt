package id.barakkastudio.sample.ui.profile.section

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import id.barakkastudio.core.R

/** Created by github.com/im-o on 5/13/2023. */

@Composable
fun ProfileContent() {
    Card(
        modifier = Modifier.size(160.dp),
        shape = CircleShape,
        elevation = CardDefaults.cardElevation(
            defaultElevation = 3.dp
        )
    ) {
        Image(
            painterResource(R.drawable.rival_profile),
            contentDescription = stringResource(R.string.about_page),
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )
    }
    Spacer(modifier = Modifier.size(16.dp))
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = stringResource(R.string.rivaldy),
            style = MaterialTheme.typography.bodyMedium.copy(
                fontWeight = FontWeight.Normal, fontSize = 28.sp, textAlign = TextAlign.Center
            ),
            color = Color.Black
        )
        Spacer(modifier = Modifier.size(3.dp))
        Text(
            text = stringResource(R.string.profile_web),
            style = MaterialTheme.typography.bodySmall.copy(
                fontWeight = FontWeight.Light, fontSize = 18.sp, textAlign = TextAlign.Center
            ),
            color = Color.DarkGray
        )
        Spacer(modifier = Modifier.size(16.dp))
        Text(
            text = stringResource(R.string.profile_description),
            style = MaterialTheme.typography.bodySmall.copy(
                fontWeight = FontWeight.Light, fontSize = 16.sp, textAlign = TextAlign.Center
            ),
            color = MaterialTheme.colorScheme.secondary
        )
    }
}