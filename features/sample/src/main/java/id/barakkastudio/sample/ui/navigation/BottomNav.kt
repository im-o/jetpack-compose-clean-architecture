package id.barakkastudio.sample.ui.navigation

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
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

@Composable
fun BottomNavItem(
    screen: BottomBar,
    currentDestination: NavDestination?,
    navController: NavHostController
) {
    val selected = currentDestination?.hierarchy?.any { it.route == screen.route } == true
    val background = if (selected) MaterialTheme.colorScheme.onPrimary.copy(alpha = 0.1f) else Color.Transparent
    val contentColor = if (selected) MaterialTheme.colorScheme.background else MaterialTheme.colorScheme.background.copy(alpha = 0.4f)

    Box(
        modifier = Modifier
            .height(42.dp)
            .clip(RoundedCornerShape(10.dp))
            .background(background)
            .clickable(onClick = {
                navController.navigate(screen.route) {
                    popUpTo(navController.graph.findStartDestination().id)
                    launchSingleTop = true
                }
            })
    ) {
        Row(
            modifier = Modifier.padding(start = 16.dp, end = 16.dp, top = 8.dp, bottom = 8.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            Icon(
                painter = painterResource(id = if (selected) screen.iconFocused else screen.icon),
                contentDescription = stringResource(id = screen.titleResId),
                tint = contentColor
            )
            AnimatedVisibility(visible = selected) {
                Text(
                    text = stringResource(id = screen.titleResId),
                    color = contentColor
                )
            }
        }
    }
}