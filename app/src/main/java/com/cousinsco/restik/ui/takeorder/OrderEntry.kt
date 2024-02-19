package com.cousinsco.restik.ui.takeorder

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.cousinsco.restik.navigation.AppScreens

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OrderEntryScreen(navController: NavController){


    Scaffold(topBar = {
        TopAppBar(
            title = {
                Box(
                    modifier = Modifier.fillMaxWidth(),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "SİPARİŞİ GİR",
                        fontSize = 20.sp,
                        fontFamily = FontFamily.Serif,
                        color = Color.White,
                        modifier = Modifier,
                        textAlign = TextAlign.Start
                    )
                }
            },
            navigationIcon = {
                IconButton(
                    onClick = {
                        navController.navigate(AppScreens.TakeOrderScreen.route)
                    }
                ) {
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = "Back Icon",
                        tint = Color.White,
                        modifier = Modifier.size(30.dp)
                    )
                }
            },
            colors = TopAppBarDefaults.mediumTopAppBarColors(
                containerColor = Color.Blue
            )
        )
    }

    )
    {paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {


        }

    }

}

@Preview(showBackground = true)
@Composable
fun OrderEntryPreview(){
    OrderEntryScreen(navController = rememberNavController())
}