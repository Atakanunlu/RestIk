package com.cousinsco.restik.ui.takeorder


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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.AlertDialog
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.cousinsco.restik.navigation.AppScreens


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TakeOrderScreen(navController: NavController){

    var tableNumber by remember { mutableStateOf("") }
    var showDialog by remember { mutableStateOf(false) }


    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                        Box(
                            modifier = Modifier.fillMaxWidth(),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(text = "Sipariş Al",
                            fontSize = 20.sp,
                            fontFamily = FontFamily.Serif,
                            color = Color.White,
                            modifier = Modifier,
                                textAlign = TextAlign.Center
                            )
                        }
                },
                navigationIcon = {
                                 IconButton(
                                     onClick = {
                                         navController.navigate(AppScreens.MainScreenn.route)
                                     }
                                 ) {
                                     Icon(
                                         imageVector = Icons.Default.ArrowBack,
                                         contentDescription = "Back Icon",
                                         tint = Color.White,
                                         modifier = Modifier.size(30.dp))
                                 }
                }

                ,colors = TopAppBarDefaults.mediumTopAppBarColors(
                    containerColor = Color.Blue
                )
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 100.dp)
                .padding(paddingValues),
                horizontalAlignment = Alignment.CenterHorizontally,

        )
        {
            OutlinedTextField(
                value =tableNumber ,
                onValueChange = {
                                if (it.all { char ->
                                        char.isDigit()
                                    }){
                                    tableNumber = it
                                }
                },
                label = { Text(text = "Masa Numarasını Giriniz:")},
                modifier = Modifier
                    .padding(top = 80.dp, start = 10.dp),
                singleLine = true,
                keyboardOptions = KeyboardOptions.Default.copy(
                    keyboardType = KeyboardType.Number
                )
            )
            Spacer(modifier = Modifier.height(16.dp))

            Button(
                onClick = {
                    if (tableNumber.isNotEmpty()) {
                        showDialog = true
                    }
                },
                modifier = Modifier
                    .width(180.dp)
                    .height(50.dp)
                    .padding(end = 5.dp),
                shape = CutCornerShape(10.dp),
                colors = ButtonDefaults.buttonColors(Color.Blue),
                enabled = tableNumber.isNotEmpty(),
            ) {
                Text(text = "Sipariş Gir")
            }

            if (showDialog){
                AlertDialog(
                    onDismissRequest = {
                        showDialog = true
                },
                    title = {
                        Text(text = "Girdiğiniz Masa Numarası:")
                    },
                    text = {
                        Text(text = tableNumber,
                        fontSize = 24.sp,
                        modifier = Modifier
                            .align(Alignment.CenterHorizontally)
                        )

                    },
                    buttons = {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(8.dp),
                            horizontalArrangement = Arrangement.SpaceEvenly
                        ) {
                            Button(
                                onClick = {

                                    showDialog = false

                                    navController.navigate(AppScreens.OrderEntryScreen.route)
                                },
                                modifier = Modifier
                                    .width(100.dp)
                                    .height(40.dp)
                                    .padding(end = 5.dp),
                                shape = CutCornerShape(10.dp),
                                colors = ButtonDefaults.buttonColors(Color.Blue)
                            ) {
                                Text(text = "Devam Et")
                            }
                            Button(
                                onClick = {
                                    showDialog = false
                                },
                                modifier = Modifier
                                    .width(100.dp)
                                    .height(40.dp)
                                    .padding(end = 5.dp),
                                shape = CutCornerShape(10.dp),
                                colors = ButtonDefaults.buttonColors(Color.Blue)

                            ) {
                                Text(text = "Vazgeç")
                            }

                        }
                    }
                )

            }

        }

    }

}



@Preview(showBackground = true)
@Composable
fun TakeOrderPreview(){
    TakeOrderScreen(navController = rememberNavController())

}