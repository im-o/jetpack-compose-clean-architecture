package id.rivaldy.composeapp.ui.screen.profile

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
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
import id.rivaldy.core.R
import id.rivaldy.core.ui.theme.Gray200

/** Created by github.com/im-o on 12/12/2022. */

@Composable
fun ProfileScreen() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = stringResource(R.string.profile))
                },
                backgroundColor = MaterialTheme.colors.primary,
                contentColor = Color.White,
                elevation = 0.dp
            )
        }, content = {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .fillMaxSize()
                    .background(Gray200)
                    .padding(it)
            ) {
                Column(
                    modifier = Modifier
                        .align(Alignment.TopCenter)
                        .padding(32.dp)
                        .fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    ProfileContent()
                }
            }
        })
}

@Composable
fun ProfileContent() {
    Card(
        modifier = Modifier.size(160.dp),
        shape = CircleShape,
        elevation = 3.dp
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
            style = MaterialTheme.typography.subtitle1.copy(
                fontWeight = FontWeight.Normal, fontSize = 28.sp, textAlign = TextAlign.Center
            ),
            color = Color.Black
        )
        Spacer(modifier = Modifier.size(3.dp))
        Text(
            text = stringResource(R.string.rival_mail),
            style = MaterialTheme.typography.subtitle2.copy(
                fontWeight = FontWeight.Light, fontSize = 18.sp, textAlign = TextAlign.Center
            ),
            color = Color.DarkGray
        )
        Spacer(modifier = Modifier.size(16.dp))
        Text(
            text = stringResource(R.string.job_description),
            style = MaterialTheme.typography.subtitle2.copy(
                fontWeight = FontWeight.Light, fontSize = 20.sp, textAlign = TextAlign.Center
            ),
            color = MaterialTheme.colors.secondary
        )
    }
}
