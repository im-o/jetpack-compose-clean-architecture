package id.barakkastudio.sample.ui.navigation.navdrawer.sections

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import id.barakkastudio.core.util.Dimens
import id.barakkastudio.sample.ui.navigation.model.BottomBar

/** Created by github.com/im-o on 11/17/2023. */

@Composable
fun NavDrawerMenu(
    modifier: Modifier = Modifier,
    navigationItemContentList: List<BottomBar>,
    navController: NavHostController,
    currentDestination: NavDestination?,
    onDrawerAction: () -> Unit,
) {
    Column(
        modifier = modifier.fillMaxSize()
    ) {
        navigationItemContentList.forEach { screen ->
            NavDrawerItem(
                modifier = modifier,
                screen = screen,
                currentDestination = currentDestination,
                navController = navController,
                onDrawerAction = onDrawerAction,
            )
            Spacer(modifier = modifier.height(Dimens.dp16))
        }
    }
}

@Composable
fun NavDrawerItem(
    modifier: Modifier = Modifier,
    screen: BottomBar,
    currentDestination: NavDestination?,
    navController: NavHostController,
    onDrawerAction: () -> Unit,
) {
    val selected = currentDestination?.hierarchy?.any { it.route == screen.route } == true
    val background = if (selected) MaterialTheme.colorScheme.onPrimary.copy(alpha = 0.1f) else Color.Transparent
    val contentColor = if (selected) MaterialTheme.colorScheme.background else MaterialTheme.colorScheme.background.copy(alpha = 0.4f)

    Box(
        modifier = modifier
            .height(Dimens.dp42)
            .clip(RoundedCornerShape(Dimens.dp10))
            .background(background)
            .clickable(onClick = {
                onDrawerAction()
                navController.navigate(screen.route) {
                    popUpTo(navController.graph.findStartDestination().id)
                    launchSingleTop = true
                }
            })
    ) {
        Row(
            modifier = modifier
                .padding(Dimens.dp8)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(Dimens.dp0)
        ) {
            Icon(
                painter = painterResource(id = if (selected) screen.iconFocused else screen.icon),
                contentDescription = stringResource(id = screen.titleResId),
                tint = contentColor
            )
            Spacer(modifier = modifier.width(Dimens.dp8))
            Text(
                text = stringResource(id = screen.titleResId),
                color = contentColor
            )
        }
    }
}