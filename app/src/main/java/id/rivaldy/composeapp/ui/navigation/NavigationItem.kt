package id.rivaldy.composeapp.ui.navigation

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

/** Created by github.com/im-o on 12/12/2022. */

sealed class NavigationItem(
    val route: String,
    @StringRes val titleResId: Int,
    @DrawableRes val icon: Int,
    @DrawableRes val iconFocused: Int
)