package id.barakkastudio.sample.ui.navigation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import id.barakkastudio.sample.ui.navigation.model.BottomBar
import id.barakkastudio.sample.ui.navigation.model.BottomBarScreen

/** Created by github.com/im-o on 5/13/2023. */

@Composable
fun BottomNav(
    modifier: Modifier = Modifier,
    navigationItemContentList: List<BottomBar>,
    navController: NavHostController = rememberNavController(),
    currentDestination: NavDestination?
) {
    Scaffold(
        modifier = modifier,
        containerColor = MaterialTheme.colorScheme.primary,
        bottomBar = {
            // show and hide bottom navigation
            if (currentDestination?.route == BottomBarScreen.Home.route ||
                currentDestination?.route == BottomBarScreen.Cart.route ||
                currentDestination?.route == BottomBarScreen.Profile.route
            ) {
                BottomBar(
                    modifier = modifier,
                    navController = navController,
                    navigationItemContentList = navigationItemContentList,
                    currentDestination = currentDestination
                )
            }
        },
    ) {
        MainNavHost(navController = navController, innerPadding = it)
    }
}

@Composable
fun BottomBar(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    navigationItemContentList: List<BottomBar>,
    currentDestination: NavDestination?
) {
    Row(
        modifier = modifier
            .padding(start = 0.dp, end = 0.dp, top = 10.dp, bottom = 10.dp)
            .background(Color.Transparent)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically
    ) {
        navigationItemContentList.forEach { screen ->
            BottomNavItem(
                screen = screen,
                currentDestination = currentDestination,
                navController = navController
            )
        }
    }
}