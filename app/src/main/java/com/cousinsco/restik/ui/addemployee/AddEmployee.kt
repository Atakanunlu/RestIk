package com.cousinsco.restik.ui.addemployee

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CutCornerShape
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
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.cousinsco.restik.R
import com.cousinsco.restik.components.LargeDropdownMenu
import com.cousinsco.restik.core.EnumRoles
import com.cousinsco.restik.core.toStringList
import com.cousinsco.restik.navigation.AppScreens

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable

fun AddEmployeeScreen(navController: NavController) {

    var selectedIndex by remember { mutableIntStateOf(-1) }

    var firstName by remember { mutableStateOf("") }
    var lastName by remember { mutableStateOf("") }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Box(
                        modifier = Modifier.fillMaxWidth(),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = stringResource(id = R.string.addemployee),
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
                            navController.navigate(AppScreens.MainScreenn.route)
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
    { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            horizontalAlignment = Alignment.CenterHorizontally

        )
        {
            OutlinedTextField(
                value = firstName,
                onValueChange = { firstName = it },
                label = { Text(text = stringResource(id = R.string.firstname)) },

                modifier = Modifier
                    .padding(bottom = 10.dp)
                    .fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(20.dp))
            OutlinedTextField(
                value = lastName,
                onValueChange = { lastName = it },
                modifier = Modifier.fillMaxWidth(),
                label = { Text(text = stringResource(id = R.string.lastname)) },
                textStyle = TextStyle.Default.copy(fontSize = 16.sp)
            )
            Spacer(modifier = Modifier.height(40.dp))

            LargeDropdownMenu(
                label = stringResource(id = R.string.chooserole),
                items = EnumRoles.values().toStringList(),
                selectedIndex = selectedIndex,
                onItemSelected = { index, _ -> selectedIndex = index },
            )

            Spacer(modifier = Modifier.height(60.dp))

            Button(onClick = {  },
                modifier = Modifier
                    .fillMaxWidth(),
                shape = CutCornerShape(10.dp),
                colors = ButtonDefaults.buttonColors(Color.Blue)) {
                Text(text = stringResource(id = R.string.save),fontSize = 30.sp)
            }
        }
    }

}
@Preview(showBackground = true)
@Composable
fun DefaultAddEmployeeScreen() {
    AddEmployeeScreen(navController = rememberNavController())
}