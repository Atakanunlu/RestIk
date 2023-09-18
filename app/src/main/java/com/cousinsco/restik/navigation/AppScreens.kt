package com.cousinsco.restik.navigation

sealed class AppScreens (val route: String) {

    object SplashScreen: AppScreens("splash_screen")

    object LoginScreen : AppScreens("login_screen")
    object MainScreenn : AppScreens("main_screenn")
    object ProfileScreen : AppScreens("profile_screen")
    object AddEmpyloyeeScreen : AppScreens("roles_screen")
}