package id.barakkastudio.nebenginaja.ui.screen

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import id.barakkastudio.core.ui.theme.JetShopeeTheme
import id.barakkastudio.nebenginaja.ui.screen.main.BottomNav

/** Created by github.com/im-o on 12/12/2022. */

@Composable
fun JetMainScreen(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
) {
    BottomNav(modifier, navController)
}

@Preview(showBackground = true, device = Devices.PIXEL_4)
@Composable
fun DefaultPreview() {
    JetShopeeTheme {
        JetMainScreen()
    }
}