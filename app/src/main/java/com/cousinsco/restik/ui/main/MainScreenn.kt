package com.cousinsco.restik.ui.main


import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource

import androidx.compose.ui.text.font.FontFamily

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


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(navController: NavController) {

    Scaffold (
        topBar = {
            TopAppBar(
                title = {
                    Box(modifier = Modifier.fillMaxWidth(),
                        contentAlignment = Alignment.Center){
                        Text(text = "İşlem Menüsü",
                            fontSize = 40.sp,
                            fontFamily = FontFamily.Serif,
                            color = Color.White
                        )
                    }

                },
                actions = {
                    IconButton(onClick = {
                        navController.navigate(AppScreens.ProfileScreen.route)
                    }) {
                        Icon(imageVector = Icons.Default.Person,
                            contentDescription = "Person Icon",
                            tint = Color.White,
                            modifier = Modifier.size(90.dp)
                        )
                    }

                },

                colors = TopAppBarDefaults.mediumTopAppBarColors(
                    containerColor = Color.Blue
                )
            )
        }
    ) {
        Column(modifier = Modifier
            .fillMaxSize()
            ,
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center){

            Spacer(modifier = Modifier.height(70.dp))

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(8.dp)
            ) {
                Spacer(modifier = Modifier.height(100.dp))

                Column(
                    modifier = Modifier
                        .fillMaxSize()
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
                            shape = CutCornerShape(10.dp),
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
                    Spacer(modifier = Modifier.height(40.dp))
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                    ) {
                        Button(
                            onClick = {
                                navController.navigate(AppScreens.AddEmpyloyeeScreen.route)
                            },
                            modifier = Modifier
                                .weight(1f)
                                .padding(end = 5.dp),
                            shape = CutCornerShape(10.dp),
                            colors = ButtonDefaults.buttonColors(Color.Blue)
                        ) {
                            Icon(
                                painter = painterResource(id = R.drawable.adddd),
                                contentDescription = "Çalışan Ekle Icon",
                                modifier = Modifier
                                    .size(50.dp)
                                    .padding(5.dp)
                            )
                            Text(text = stringResource(id = R.string.addemployee1),
                                fontSize = 30.sp)
                        }

                        Spacer(modifier = Modifier.height(50.dp))
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



