package id.barakkastudio.nebenginaja.ui

import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import id.barakkastudio.nebenginaja.utils.JetNavigationType

/** Created by github.com/im-o on 10/28/2023. */

@Composable
fun JetMainApp(
    windowSize: WindowWidthSizeClass,
    modifier: Modifier = Modifier,
) {
    val navigationType: JetNavigationType = when (windowSize) {
        WindowWidthSizeClass.Compact -> {
            JetNavigationType.BOTTOM_NAVIGATION
        }

        WindowWidthSizeClass.Medium -> {
            JetNavigationType.NAVIGATION_RAIL
        }

        WindowWidthSizeClass.Expanded -> {
            JetNavigationType.PERMANENT_NAVIGATION_DRAWER
        }

        else -> {
            JetNavigationType.BOTTOM_NAVIGATION
        }
    }

    JetMainScreen(navigationType = navigationType, modifier = modifier)
}