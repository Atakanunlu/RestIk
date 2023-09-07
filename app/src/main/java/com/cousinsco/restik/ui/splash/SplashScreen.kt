package com.cousinsco.restik.ui.splash

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.cousinsco.restik.R
import com.cousinsco.restik.navigation.AppScreens
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navController: NavHostController){

    LaunchedEffect(key1 = true ){
        delay(5000)

        navController.popBackStack()
        navController.navigate(AppScreens.MainScreen.route)
    }



    Splash()
}

@Composable
fun Splash(){

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(painter = painterResource(id = R.drawable.logoo),
            contentDescription = "RestIk",
            Modifier.size(300.dp,200.dp))

    }

}


@Preview(showBackground = true)
@Composable
fun SplashScreenPreview() {
    Splash()

}