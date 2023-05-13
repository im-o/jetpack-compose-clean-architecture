package com.rivaldy.id.compose.ui.navigation

import com.rivaldy.id.core.R

/** Created by github.com/im-o on 5/8/2023. */

sealed class BottomBarScreen(val route: String) {
    object Home : NavigationItem(
        route = "home",
        titleResId = R.string.home,
        icon = R.drawable.home,
        iconFocused = R.drawable.home
    )

    object Cart : NavigationItem(
        route = "cart",
        titleResId = R.string.cart,
        icon = R.drawable.cart,
        iconFocused = R.drawable.cart
    )

    object Profile : NavigationItem(
        route = "profile",
        titleResId = R.string.profile,
        icon = R.drawable.user,
        iconFocused = R.drawable.user
    )
}