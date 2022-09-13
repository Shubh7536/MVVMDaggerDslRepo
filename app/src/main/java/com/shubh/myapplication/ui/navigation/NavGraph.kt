package com.shubh.myapplication.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.shubh.myapplication.ui.screens.login.Login

import com.shubh.myapplication.ui.screens.slider.SliderScreen
import com.shubh.myapplication.ui.screens.splash.SplashScreen

@Composable
fun NavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = NavRoute.Splash.path
    ) {
        addSplashScreen(navController,this)

        addSliderScreen(navController,this)

        addLoginScreen(navController, this)
    }


}

private fun addSplashScreen(
    navController: NavHostController,
    navGraphBuilder: NavGraphBuilder
) {
    navGraphBuilder.composable(route = NavRoute.Splash.path) {
        SplashScreen(
            navToSlider = {
                navController.popBackStack()
                navController.navigate(NavRoute.Slider.path)
            }
        )
    }
}


private fun addLoginScreen(
    navController: NavHostController,
    navGraphBuilder: NavGraphBuilder
) {
    navGraphBuilder.composable(route = NavRoute.Login.path) {
        Login().LoginScreen(
          navigationToSlider = {

          }
        )
    }
}


private fun addSliderScreen(
    navController: NavHostController,
    navGraphBuilder: NavGraphBuilder
) {
    navGraphBuilder.composable(route = NavRoute.Slider.path) {
        SliderScreen(natToLogin = {
            navController.popBackStack()
            navController.navigate(NavRoute.Login.path)
        })
    }
}

/*
private fun addHomeScreen(
    navController: NavHostController,
    navGraphBuilder: NavGraphBuilder
) {
    navGraphBuilder.composable(route = NavRoute.Home.path) {

        HomeScreen(
            navigateToProfile = { id, showDetails ->
                navController.navigate(NavRoute.Profile.withArgs(id.toString(), showDetails.toString()))
            },
            navigateToSearch = { query ->
                navController.navigate(NavRoute.Search.withArgs(query))
            },
            popBackStack = { navController.popBackStack() },
            popUpToLogin= { popUpToLogin(navController) },
        )
    }
}
*/

private fun popUpToLogin(navController: NavHostController) {
    navController.popBackStack(NavRoute.Login.path, inclusive = false)
}
/*

private fun addProfileScreen(
    navController: NavHostController,
    navGraphBuilder: NavGraphBuilder
) {
    navGraphBuilder.composable(
        route = NavRoute.Profile.withArgsFormat(NavRoute.Profile.id, NavRoute.Profile.showDetails),
        arguments = listOf(
            navArgument(NavRoute.Profile.id) {
                type = NavType.IntType
            }
            ,
            navArgument(NavRoute.Profile.showDetails) {
                type = NavType.BoolType
            }
        )
    ) { navBackStackEntry ->

        val args = navBackStackEntry.arguments

        ProfileScreen(
            id = args?.getInt(NavRoute.Profile.id)!!,
            showDetails = args.getBoolean(NavRoute.Profile.showDetails),
            popBackStack = { navController.popBackStack() },
            popUpToLogin = { popUpToLogin(navController) }
        )
    }
}

private fun addSearchScreen(
    navController: NavHostController,
    navGraphBuilder: NavGraphBuilder
) {
    navGraphBuilder.composable(
        route = NavRoute.Search.withArgsFormat(NavRoute.Search.query),
        arguments = listOf(
            navArgument(NavRoute.Search.query) {
                type = NavType.StringType
                nullable = true
            }
        )
    ) { navBackStackEntry ->

        val args = navBackStackEntry.arguments

        SearchScreen(
            query = args?.getString(NavRoute.Search.query),
            popBackStack = { navController.popBackStack() },
            popUpToLogin = { popUpToLogin(navController) }
        )
    }
}*/
