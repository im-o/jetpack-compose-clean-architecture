package com.rivaldy.id.compose.ui.navigation

/** Created by github.com/im-o on 5/10/2023. */

sealed class GeneralScreen(val route: String) {
    object SearchProduct : GeneralScreen(route = "home/search") {
        fun createRoute() = "home/search"
    }
}