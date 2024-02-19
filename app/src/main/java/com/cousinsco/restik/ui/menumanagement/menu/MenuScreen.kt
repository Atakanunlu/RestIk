package com.cousinsco.restik.ui.menumanagement.menu



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

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
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
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

import androidx.compose.ui.graphics.Color



import androidx.compose.ui.res.painterResource

import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.cousinsco.restik.R
import com.cousinsco.restik.core.database.entity.CategoryEntity


import com.cousinsco.restik.navigation.AppScreens


@OptIn(ExperimentalMaterial3Api::class)
@Composable

fun MenuScreen(navController: NavController,viewModel: MenuViewModel = hiltViewModel()) {


    val categoryId: Int by rememberSaveable { mutableIntStateOf(0) }
    var categoryName by rememberSaveable { mutableStateOf("") }
    OutlinedTextField(value = categoryName, onValueChange = { categoryName = it })

    var expanded by remember { mutableStateOf(false) }
    var customCategory by remember { mutableStateOf("") }
    val categories = remember { mutableStateListOf<String>() }
    val productsMap = remember { mutableStateMapOf<String,MutableList<String>>() }
    var selectedCategory by remember { mutableStateOf<String?>(null) }
    var customProduct by remember { mutableStateOf("") }


    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Box(
                        modifier = Modifier.fillMaxWidth(),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = "Menü Yönetimi",
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
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Back Icon",
                            tint = Color.White,
                            modifier = Modifier.size(30.dp)
                        )
                    }
                },
                actions = {
                    IconButton(onClick = {
                        navController.navigate(AppScreens.GivePermissionScreen.route)
                    }) {
                        Icon(
                            painter = painterResource(id = R.drawable.baseline_supervisor_account_24),
                            contentDescription = "as",
                            tint = Color.White,
                            modifier = Modifier.size(40.dp)
                        )
                    }
                },
                colors = TopAppBarDefaults.mediumTopAppBarColors(
                    containerColor = Color.Blue
                )
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(top = 28.dp)
        ){
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                OutlinedTextField(
                    value =customCategory,
                    onValueChange ={newCustomCategory ->
                        customCategory = newCustomCategory
                    },
                    label = {R.string.addcategory},
                    modifier = Modifier
                        .weight(0.5f)
                        .padding(end = 8.dp)
                )
                Button(
                    onClick = {

                        if (customCategory.isNotBlank()){

                            productsMap[customCategory] = mutableListOf()
                            customCategory = ""
                        }

                        val category = CategoryEntity(categoryId,categoryName)
                        viewModel.addCategory(category)


                    },
                    modifier = Modifier
                        .width(125.dp)
                        .height(60.dp)
                        .padding(end = 5.dp),
                    shape = CutCornerShape(10.dp),
                    colors = ButtonDefaults.buttonColors(Color.Blue)
                ) {
                    Text(
                        text = "Kategoriyi oluştur.",
                        fontSize = 15.sp
                    )
                }
            }
            Spacer(modifier = Modifier.height(16.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                ExposedDropdownMenuBox(
                    expanded = expanded,
                    onExpandedChange ={expanded = it},
                ) {
                    OutlinedTextField(
                        value =selectedCategory ?: "" ,
                        onValueChange = {categoryName = it},
                        label = { Text(text = "Kategori Seçiniz") },
                        modifier = Modifier.menuAnchor(),
                        readOnly = true,
                        trailingIcon = {
                            if(selectedCategory !=null){
                                IconButton(
                                    onClick = {
                                        categories.remove(selectedCategory!!)
                                        productsMap.remove(selectedCategory!!)
                                        selectedCategory = null
                                    }
                                ) {
                                    Icon(
                                        imageVector =Icons.Default.Close ,
                                        contentDescription = "Delete Category",
                                        tint = Color.Red
                                    )
                                }
                            }
                        },
                        colors = ExposedDropdownMenuDefaults
                            .outlinedTextFieldColors(containerColor = Color.Transparent)
                    )
                    ExposedDropdownMenu(
                        expanded = expanded ,
                        onDismissRequest = { expanded = false }
                    ) {
                        categories.forEach { category ->

                            DropdownMenuItem(
                                text = {
                                    Row(
                                        verticalAlignment = Alignment.CenterVertically,
                                        horizontalArrangement = Arrangement.SpaceBetween
                                    ) {
                                        Text(category)

                                    }
                                },
                                onClick = {
                                    selectedCategory = category
                                    expanded = false
                                },
                                contentPadding = ExposedDropdownMenuDefaults.ItemContentPadding,
                            )
                        }
                    }
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            selectedCategory?.let { category ->
                OutlinedTextField(
                    value =customProduct ,
                    onValueChange = {newCustomProduct ->
                        customProduct = newCustomProduct
                    },
                    label = { Text(text = "Ürün Ekle")},
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(8.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Button(
                        onClick = {
                            if (customProduct.isNotBlank()){
                                val prodctList = productsMap[category] ?: mutableListOf()
                                prodctList.add(customProduct)
                                productsMap[category] = prodctList
                                customProduct = ""
                            }
                        },
                        modifier = Modifier.weight(1f)
                    ) {
                        Text(text = "Ürün Ekle")
                    }
                }
                Spacer(modifier = Modifier.height(16.dp))

                Text(
                    text ="Secilen Kategori:$category",
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                    modifier = Modifier.padding(start = 20.dp)
                )
                Spacer(modifier = Modifier.height(8.dp))

                productsMap[category]?.forEach { product ->
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            text =product,
                            fontSize = 20.sp,
                            modifier = Modifier
                                .weight(1f)
                                .padding(start = 25.dp)
                        )
                        IconButton(
                            onClick = {
                                val productList = productsMap[category] ?: return@IconButton
                                productList.remove(product)
                                productsMap[category] = productList
                            }
                        ) {
                            Icon(
                                imageVector =Icons.Default.Close ,
                                contentDescription = "Delete product",
                                tint = Color.Red
                            )
                        }
                    }
                }

            }
            Spacer(modifier = Modifier.height(16.dp))

            Button(
                onClick = {

                },
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .width(125.dp)
                    .height(60.dp)
                    .padding(end = 5.dp),
                shape = CutCornerShape(10.dp),
                colors = ButtonDefaults.buttonColors(Color.Blue)
            ) {
                Text(
                    text = "Kaydet",
                    fontSize = 18.sp
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MenuScreenPreview() {
    MenuScreen(navController = rememberNavController())

}
