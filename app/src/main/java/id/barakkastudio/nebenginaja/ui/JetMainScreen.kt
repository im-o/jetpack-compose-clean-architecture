package id.barakkastudio.nebenginaja.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import id.barakkastudio.core.ui.theme.JetShopeeTheme
import id.barakkastudio.nebenginaja.utils.JetNavigationType
import id.barakkastudio.sample.ui.navigation.BottomNav
import id.barakkastudio.sample.ui.navigation.NavRail
import id.barakkastudio.sample.ui.navigation.model.BottomBarScreen
import id.barakkastudio.sample.ui.navigation.navdrawer.NavDrawer

/** Created by github.com/im-o on 12/12/2022. */

@Composable
fun JetMainScreen(
    modifier: Modifier = Modifier,
    navigationType: JetNavigationType,
    navController: NavHostController = rememberNavController(),
) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    val navigationItemContentList = listOf(
        BottomBarScreen.Home,
        BottomBarScreen.Cart,
        BottomBarScreen.Profile
    )

    when (navigationType) {
        JetNavigationType.BOTTOM_NAVIGATION -> {
            BottomNav(
                modifier = modifier,
                navigationItemContentList = navigationItemContentList,
                navController = navController,
                currentDestination = currentDestination,
            )
        }

        JetNavigationType.NAVIGATION_RAIL -> {
            NavRail(
                modifier = modifier,
                navigationItemContentList = navigationItemContentList,
                navController = navController,
                currentDestination = currentDestination,
            )
        }

        JetNavigationType.PERMANENT_NAVIGATION_DRAWER -> {
            NavDrawer(
                modifier = modifier,
                navigationItemContentList = navigationItemContentList,
                navController = navController,
                currentDestination = currentDestination,
            )
        }
    }
}

@Preview(showBackground = true, device = Devices.PIXEL_4)
@Composable
fun DefaultPreview() {
    JetShopeeTheme {
        JetMainScreen(navigationType = JetNavigationType.BOTTOM_NAVIGATION)
    }
}