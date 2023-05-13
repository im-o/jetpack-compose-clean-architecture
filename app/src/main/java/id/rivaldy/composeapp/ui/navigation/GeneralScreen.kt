package id.rivaldy.composeapp.ui.navigation

/** Created by github.com/im-o on 5/10/2023. */

sealed class GeneralScreen(val route: String) {

    object DetailProduct : BottomBarScreen("home/{productId}") {
        fun createRoute(productId: Int) = "home/$productId"
    }

    object SearchProduct : GeneralScreen(route = "home/search")
}