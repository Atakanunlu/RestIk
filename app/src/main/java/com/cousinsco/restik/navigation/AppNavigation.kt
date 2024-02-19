package com.cousinsco.restik.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.cousinsco.restik.ui.addemployee.AddEmployeeScreen
import com.cousinsco.restik.ui.login.LoginScreen
import com.cousinsco.restik.ui.main.MainScreen
import com.cousinsco.restik.ui.menumanagement.GivePermissionScreen
import com.cousinsco.restik.ui.menumanagement.menu.MenuScreen
import com.cousinsco.restik.ui.profile.ProfileScreen

import com.cousinsco.restik.ui.splash.SplashScreen
import com.cousinsco.restik.ui.takeorder.OrderEntryScreen
import com.cousinsco.restik.ui.takeorder.TakeOrderScreen


@Composable
fun AppNavigation(){
    val navController = rememberNavController()
    NavHost(navController = navController,
        startDestination = AppScreens.SplashScreen.route){

        composable(AppScreens.SplashScreen.route){
            SplashScreen(navController = navController)
        }

        composable(AppScreens.LoginScreen.route){
            LoginScreen(navController=navController)
        }
        composable(AppScreens.MainScreenn.route){
            MainScreen(navController = navController)
        }
        composable(AppScreens.ProfileScreen.route){
            ProfileScreen(navController = navController)
        }
        composable(AppScreens.AddEmpyloyeeScreen.route){
            AddEmployeeScreen(navController = navController)
        }
        composable(AppScreens.MenuScreen.route){
            MenuScreen(navController = navController)
        }
        composable(AppScreens.TakeOrderScreen.route){
            TakeOrderScreen(navController = navController)
        }
        composable(AppScreens.OrderEntryScreen.route){
            OrderEntryScreen(navController = navController)
        }
        composable(AppScreens.GivePermissionScreen.route){
            GivePermissionScreen(navController = navController)
        }

    }
}