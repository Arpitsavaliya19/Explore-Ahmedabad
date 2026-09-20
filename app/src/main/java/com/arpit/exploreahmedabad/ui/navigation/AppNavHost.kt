package com.arpit.exploreahmedabad.ui.navigation

import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.arpit.exploreahmedabad.data.model.PlaceCategory
import com.arpit.exploreahmedabad.ui.screens.CategoryScreen
import com.arpit.exploreahmedabad.ui.screens.DetailScreen
import com.arpit.exploreahmedabad.ui.screens.HomeScreen
import com.arpit.exploreahmedabad.ui.screens.SplashScreen
import com.arpit.exploreahmedabad.ui.viewmodel.SharedViewModel

@Composable
fun AppNavigation(
    navController: NavHostController,
    windowWidthSize: WindowSizeClass,
    modifier: Modifier = Modifier,
    viewModel: SharedViewModel = viewModel()
) {
    NavHost(
        navController = navController,
        startDestination = NavRoutes.SplashScreen.route,
        modifier = modifier
    ) {
        composable(route = NavRoutes.SplashScreen.route) {
            SplashScreen(navController = navController)
        }
        composable(route = NavRoutes.HomeScreen.route) {
            HomeScreen(navController = navController, windowWidthSize = windowWidthSize, viewModel = viewModel)
        }
        composable(
            route = NavRoutes.CategoryScreen.route,
            arguments = listOf(
                navArgument("category") {
                    type = NavType.StringType
                }
            )
        ) { backStackEntry ->
            val category = backStackEntry.arguments?.getString("category")
            if (category != null) {
                CategoryScreen(
                    navController = navController,
                    windowWidthSize = windowWidthSize,
                    viewModel = viewModel,
                    category = PlaceCategory.valueOf(category)
                )
            }
        }
        composable(
            route = NavRoutes.DetailScreen.route,
            arguments = listOf(
                navArgument("placeId") {
                    type = NavType.IntType
                }
            )
        ) {
            DetailScreen(
                navController = navController,
                viewModel = viewModel,
                windowWidthSize = windowWidthSize
            )
        }
    }
}
