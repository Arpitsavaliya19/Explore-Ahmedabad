package com.arpit.exploreahmedabad.ui.navigation

enum class NavRoutes(val route: String) {
    SplashScreen("splash"),
    HomeScreen("home"),
    CategoryScreen("category/{category}"),
    DetailScreen("detail/{placeId}"),
}
