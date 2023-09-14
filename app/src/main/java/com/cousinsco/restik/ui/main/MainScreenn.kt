package com.cousinsco.restik.ui.main

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

import com.cousinsco.restik.R
import com.cousinsco.restik.navigation.AppScreens

/*
@Composable
fun MainScreenn(navController: NavController){

    LaunchedEffect(key1 = true ){



        navController.popBackStack()
        navController.navigate(AppScreens.ProfileScreen.route)
    }



    Main()

}

 */




@Composable
fun MainScreen(navController: NavController) {


    Column(modifier = Modifier
        .fillMaxSize()
    ) {

        Box(modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(0.30f),
            Alignment.TopEnd) {
            Image(painter = painterResource(id = R.drawable.shape),
                contentDescription = "bacround",
                contentScale = ContentScale.FillBounds,
                modifier = Modifier.fillMaxSize()
            )

            Column(modifier = Modifier
                .fillMaxSize()
                .padding(20.dp, 50.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Image(painter = painterResource(id = R.drawable.logooo),
                    contentDescription = "Logo",
                    Modifier
                        .weight(1f)
                        .size(150.dp),
                    colorFilter = ColorFilter.tint(Color.White)
                )
                Text(text = stringResource(id = R.string.actionmenu),
                    fontSize = 40.sp,
                    color = Color.White,
                    fontStyle = FontStyle.Italic)

            }

        }




        Column(modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 100.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center) {

            Button(onClick = {
                navController.navigate(AppScreens.ProfileScreen.route)


            },
                shape = CutCornerShape(10.dp)

                ,colors = ButtonDefaults.buttonColors(containerColor = Color.Blue)) {
                Icon(painter = painterResource(id = R.drawable.profilicon),
                    contentDescription ="Profil Icon",
                    modifier = Modifier
                        .size(40.dp)
                        .padding(5.dp))
                Text(text = stringResource(id = R.string.profile))

            }

            Spacer(modifier = Modifier.height(50.dp))

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(8.dp)
            ) {
                Spacer(modifier = Modifier.height(10.dp))

                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 5.dp)
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(bottom = 5.dp)
                    ) {
                        Button(
                            onClick = {  },
                            modifier = Modifier
                                .weight(1f)
                                .padding(end = 5.dp),
                            shape = CutCornerShape(10.dp),
                            colors = ButtonDefaults.buttonColors(Color.Blue)
                        ) {
                            Icon(painter = painterResource(id = R.drawable.takeorder),
                                contentDescription ="Sipariş al Icon",
                                modifier = Modifier
                                    .size(50.dp)
                                    .padding(5.dp))
                            Text(text = stringResource(id = R.string.takeorder))
                        }

                        Button(
                            onClick = {  },
                            modifier = Modifier
                                .weight(1f),
                            shape = CutCornerShape(10.dp),
                            colors = ButtonDefaults.buttonColors(Color.Blue)
                        ) {
                            Icon(painter = painterResource(id = R.drawable.reports),
                                contentDescription ="Raporlar Icon",
                                modifier = Modifier
                                    .size(50.dp)
                                    .padding(5.dp))
                            Text(text = stringResource(id = R.string.reports))

                        }
                    }

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(bottom = 5.dp)
                    ) {
                        Button(
                            onClick = {  },
                            modifier = Modifier
                                .weight(1f)
                                .padding(end = 5.dp),
                            shape = CutCornerShape(10.dp),
                            colors = ButtonDefaults.buttonColors(Color.Blue)
                        ) {
                            Icon(painter = painterResource(id = R.drawable.accounting),
                                contentDescription ="MuhasebeIcon",
                                modifier = Modifier
                                    .size(50.dp)
                                    .padding(5.dp))
                            Text(text = stringResource(id = R.string.accounting))

                        }

                        Button(
                            onClick = {  },
                            modifier = Modifier
                                .weight(1f),
                            shape = CutCornerShape(5.dp),
                            colors = ButtonDefaults.buttonColors(Color.Blue)
                        ) {
                            Icon(painter = painterResource(id = R.drawable.stok),
                                contentDescription ="Stok Yönetimi Icon",
                                modifier = Modifier
                                    .size(50.dp)
                                    .padding(5.dp))
                            Text(text = stringResource(id = R.string.stockmanagement))
                        }
                    }

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                    ) {
                        Button(
                            onClick = {  },
                            modifier = Modifier
                                .weight(1f)
                                .padding(end = 5.dp),
                            shape = CutCornerShape(10.dp),
                            colors = ButtonDefaults.buttonColors(Color.Blue)
                        ) {
                            Icon(painter = painterResource(id = R.drawable.menumanagement),
                                contentDescription ="Menü Yönetimi Icon",
                                modifier = Modifier
                                    .size(50.dp)
                                    .padding(5.dp))
                            Text(text = stringResource(id = R.string.menumanagement))
                        }

                        Button(
                            onClick = {  },
                            modifier = Modifier
                                .weight(1f),
                            shape = CutCornerShape(10.dp),
                            colors = ButtonDefaults.buttonColors(Color.Blue)
                        ) {
                            Icon(painter = painterResource(id = R.drawable.custom),
                                contentDescription ="Müşteri Yönetimi",
                                modifier = Modifier
                                    .size(50.dp)
                                    .padding(5.dp))
                            Text(text = stringResource(id = R.string.customermanagement))

                        }
                    }
                }
            }


        }

    }

}





@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
    MainScreen(navController = rememberNavController())
    

}

 

