package com.cousinsco.restik.ui.main

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
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







@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileScreen(navController: NavController) {

    val personnelNumber = remember { mutableStateOf("") }
    val userName = remember { mutableStateOf("") }
    val position = remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
        ,
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.30f),
            Alignment.TopEnd
        ) {
            Image(
                painter = painterResource(id = R.drawable.shape),
                contentDescription = "Logo Background",
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.FillBounds
            )

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .padding(horizontal = 20.dp, vertical = 50.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.logooo),
                    contentDescription = "Logo",
                    Modifier
                        .weight(1f)
                        .size(160.dp),
                    colorFilter = ColorFilter.tint(Color.White)
                )

                Text(
                    text = stringResource(id = R.string.personnelinformation),
                    fontSize = 40.sp,
                    color = Color.White,
                    fontStyle = FontStyle.Italic
                )
            }
        }

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
                    Text(text = stringResource(id = R.string.personelnumber1), fontSize = 20.sp)
                },
                placeholder = {
                    Text(text = stringResource(id = R.string.personelnumber), fontSize = 20.sp)
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
                    Text(text = stringResource(id = R.string.position1), fontSize = 20.sp)
                },
                placeholder = {
                    Text(text = stringResource(id = R.string.position), fontSize = 20.sp)
                },
                shape = RoundedCornerShape(10.dp),
                modifier = Modifier.width(260.dp)
            )

            Spacer(modifier = Modifier.padding(10.dp))
        }


        Button(
            onClick = {
                navController.navigate(AppScreens.MainScreenn.route)

            },
            modifier = Modifier
                .fillMaxWidth()
                .height(140.dp)
                .padding(bottom = 60.dp),
            shape = CutCornerShape(10.dp),
            colors = ButtonDefaults.buttonColors(Color.Blue)
        ) {
            Text(text = stringResource(id = R.string.backtomenu), fontSize = 24.sp)
        }
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview(){
    ProfileScreen(navController = rememberNavController())
}

