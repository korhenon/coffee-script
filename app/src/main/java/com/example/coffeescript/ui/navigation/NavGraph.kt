package com.example.coffeescript.ui.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.coffeescript.data.utils.NavDestinations
import com.example.coffeescript.ui.screens.login.LoginScreen
import com.example.coffeescript.ui.screens.OnboardScreen
import com.example.coffeescript.ui.screens.RegisterScreen
import com.example.coffeescript.ui.screens.SplashScreen
import com.example.coffeescript.ui.screens.home.HomeScreen

@Composable
fun NavGraph(navViewModel: NavViewModel = hiltViewModel()) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = navViewModel.startDestination) {
        composable(NavDestinations.Splash) {
            SplashScreen(navController)
        }
        composable(NavDestinations.Onboard) {
            OnboardScreen(navController)
        }
        composable(NavDestinations.Login) {
            LoginScreen(navController)
        }
        composable(NavDestinations.Register) {
            RegisterScreen(navController)
        }
        composable(NavDestinations.Home) {
            HomeScreen()
        }
    }
}