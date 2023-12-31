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
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.cousinsco.restik.R
import com.cousinsco.restik.navigation.AppScreens
import kotlinx.coroutines.delay



@Composable
fun SplashScreen(navController: NavController){
    LaunchedEffect(key1 = true ){
        delay(2000)

        navController.popBackStack()
        navController.navigate(AppScreens.LoginScreen.route)
    }


    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(painter = painterResource(id = R.drawable.logoo),
            contentDescription = "RestIk Logo",
            Modifier.size(300.dp,200.dp))

    }

}


@Preview(showBackground = true)
@Composable
fun SplashScreenPreview() {
    SplashScreen(navController = rememberNavController())

}



