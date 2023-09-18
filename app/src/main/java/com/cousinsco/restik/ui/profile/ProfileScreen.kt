package com.cousinsco.restik.ui.profile


import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.cousinsco.restik.R
import com.cousinsco.restik.navigation.AppScreens



@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileScreen(navController: NavController) {


    val personnelNumber = remember { mutableStateOf("") }
    val userName = remember { mutableStateOf("") }
    val position = remember { mutableStateOf("") }


    Scaffold (
        topBar = {
            TopAppBar(
                title = {
                    Box(modifier = Modifier.fillMaxWidth(),
                        contentAlignment = Alignment.Center){
                        Text(text = "PROFİL",
                            fontSize = 40.sp,
                            fontFamily = FontFamily.Serif,
                            color = Color.White
                        )
                    }

                },
                navigationIcon = {
                    IconButton(onClick = {
                        navController.navigate(AppScreens.MainScreenn.route)
                    }) {
                        Icon(imageVector = Icons.Default.ArrowBack,
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
            .padding(vertical = 100.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center){

            Spacer(modifier = Modifier.height(100.dp))

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 16.dp),
                verticalArrangement = Arrangement.SpaceBetween,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                TextField(
                    value = personnelNumber.value,
                    onValueChange = { personnelNumber.value = it },
                    label = {
                        Text(text = stringResource(id = R.string.profileusername1), fontSize = 20.sp)
                    },
                    placeholder = {
                        Text(text = stringResource(id = R.string.profileusername), fontSize = 20.sp)
                    },
                    shape = RoundedCornerShape(10.dp),
                    modifier = Modifier.width(260.dp)
                )

                Spacer(modifier = Modifier.padding(10.dp))

                TextField(
                    value = userName.value,
                    onValueChange = { userName.value = it },
                    label = {
                        Text(text = stringResource(id = R.string.profileusername1), fontSize = 20.sp)
                    },
                    placeholder = {
                        Text(text = stringResource(id = R.string.profileusername), fontSize = 20.sp)
                    },
                    shape = RoundedCornerShape(10.dp),
                    modifier = Modifier.width(260.dp)
                )

                Spacer(modifier = Modifier.padding(10.dp))

                TextField(
                    value = position.value,
                    onValueChange = { position.value = it },
                    label = {
                        Text(text = stringResource(id = R.string.position1) , fontSize = 20.sp)
                    },
                    placeholder = {
                        Text(text = stringResource(id = R.string.position) , fontSize = 20.sp)
                    },
                    shape = RoundedCornerShape(10.dp),
                    modifier = Modifier.width(260.dp)
                )

                Spacer(modifier = Modifier.padding(10.dp))
            }


        }


    }


}


@Preview(showBackground = true)
@Composable
fun DefaultPreview(){
    ProfileScreen(navController = rememberNavController())
}




