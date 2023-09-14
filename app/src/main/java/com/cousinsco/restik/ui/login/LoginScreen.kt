package com.cousinsco.restik.ui.login


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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.LockOpen
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

import com.cousinsco.restik.R
import com.cousinsco.restik.navigation.AppScreens


/*
@Composable
fun LoginScreen(navController: NavController){

    LaunchedEffect(key1 = true ){


        navController.popBackStack()
        navController.navigate(AppScreens.MainScreenn.route)
    }


    SignInScreen()
}

 */



@OptIn(ExperimentalMaterial3Api::class, ExperimentalComposeUiApi::class)
@Composable
fun LoginScreen(navController: NavController) {



    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    val (focusUsername,focusPassword) = remember { FocusRequester.createRefs() }
    val keyboardController = LocalSoftwareKeyboardController.current
    var passwordVisible by remember { mutableStateOf(false) }


    Column (
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.30f),
            Alignment.TopEnd
        ) {
            Image(painter = painterResource(id = R.drawable.shape),
                contentDescription = "Logo Backround",
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.FillBounds)

            Column (
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .padding(horizontal = 20.dp, vertical = 50.dp),

                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Image(painter = painterResource(id = R.drawable.logooo),
                    contentDescription = "Logo",
                    Modifier
                        .weight(1f)
                        .size(160.dp),
                    colorFilter = ColorFilter.tint(Color.White))

                Text(text = stringResource(id = R.string.welcome),
                    fontSize = 40.sp,
                    color = Color.White,
                    fontStyle = FontStyle.Italic
                )

            }

        }

        Column (
            modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth()
                .padding(horizontal = 40.dp, vertical = 80.dp)
        ) {

            Text(text = stringResource(id = R.string.log_in_title),
                style = MaterialTheme.typography.headlineLarge
            )

            OutlinedTextField(value = username,
                onValueChange ={username = it},
                modifier = Modifier
                    .fillMaxWidth()
                    .focusRequester(focusUsername),

                keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
                keyboardActions = KeyboardActions(onNext = {focusPassword.requestFocus()}),
                singleLine = true,
                label = { Text(text = stringResource(id = R.string.username)) }
            )

            Spacer(modifier = Modifier.height(8.dp))

            OutlinedTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .focusRequester(focusPassword),
                value = password,
                onValueChange = {password =it},
                label = { Text(text = stringResource(id = R.string.password)) },
                singleLine = true,

                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password,
                    imeAction = ImeAction.Done),
                keyboardActions = KeyboardActions(onDone = {keyboardController?.hide()}),
                visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),

                trailingIcon = {
                    IconButton(onClick = { passwordVisible =! passwordVisible }) {
                        Icon(imageVector = if (passwordVisible) Icons.Default.LockOpen
                        else Icons.Default.Lock,
                            contentDescription = "Şifreyi gösterme Icon butonu")

                    }
                }
            )

            Spacer(modifier = Modifier.height(16.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                Arrangement.SpaceBetween
            ) {

                Row(verticalAlignment = Alignment.CenterVertically) {

                    val rememberMe = remember {
                        mutableStateOf(false)

                    }

                    Checkbox(checked = rememberMe.value,
                        onCheckedChange = {rememberMe.value = it},
                        colors = CheckboxDefaults.colors(checkedColor = Color.Blue))

                    Text(text = stringResource(id = R.string.remember_me),
                        fontSize = 14.sp,
                        color = Color.Blue)

                }

                TextButton(onClick = {}) {
                    Text(text = stringResource(id = R.string.forget_password),
                        fontSize = 14.sp,
                        color = Color.Blue)

                }

            }

            Spacer(modifier = Modifier.height(16.dp))

            Button(onClick = {
                navController.navigate(
                    AppScreens.MainScreenn.route
                )



            },
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(16.dp),
                colors = ButtonDefaults.buttonColors(Color.Blue)) {

                Text(text = stringResource(id = R.string.log_in_button),
                    color = Color.White)


            }

            Spacer(modifier = Modifier.height(16.dp))

        }

    }



}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {

    LoginScreen(navController = rememberNavController())
}
