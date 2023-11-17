package id.barakkastudio.sample.ui.navigation.navdrawer

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.navigation.NavDestination
import androidx.navigation.NavHostController
import id.barakkastudio.core.util.Dimens
import id.barakkastudio.sample.ui.navigation.MainNavHost
import id.barakkastudio.sample.ui.navigation.model.BottomBar
import id.barakkastudio.sample.ui.navigation.navdrawer.sections.NavDrawerSection
import kotlinx.coroutines.launch

/** Created by github.com/im-o on 11/14/2023. */

@Composable
fun NavDrawer(
    modifier: Modifier = Modifier,
    navigationItemContentList: List<BottomBar>,
    navController: NavHostController,
    currentDestination: NavDestination?
) {
    val drawerState = rememberDrawerState(DrawerValue.Closed)
    val coroutineScope = rememberCoroutineScope()

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet(
                drawerShape = RectangleShape
            ) {
                NavDrawerSection(
                    modifier = modifier,
                    navigationItemContentList = navigationItemContentList,
                    navController = navController,
                    currentDestination = currentDestination,
                    onDrawerAction = {
                        coroutineScope.launch {
                            if (drawerState.isOpen) drawerState.close() else drawerState.open()
                        }
                    },
                )
            }
        }
    ) {
        MainNavHost(navController = navController, innerPadding = PaddingValues(end = Dimens.dp0))
    }
}