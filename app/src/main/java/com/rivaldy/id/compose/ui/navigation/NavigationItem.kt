package com.rivaldy.id.compose.ui.navigation

import androidx.compose.ui.graphics.vector.ImageVector

/** Created by github.com/im-o on 12/12/2022. */

data class NavigationItem(
    val title: String,
    val icon: ImageVector,
    val screen: Screen
)