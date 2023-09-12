package com.cousinsco.restik.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.cousinsco.restik.ui.login.LoginScreen
import com.cousinsco.restik.ui.splash.SplashScreen


@Composable
fun AppNavigation(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination =AppScreens.SplashScreen.route){
        composable(AppScreens.SplashScreen.route){
            SplashScreen(navController = navController)
        }
        
        composable(AppScreens.LoginScreen.route){
            LoginScreen()
        }

    }
}