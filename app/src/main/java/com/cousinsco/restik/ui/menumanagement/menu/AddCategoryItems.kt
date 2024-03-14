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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.cousinsco.restik.R


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddCategoryItems(
    state: MutableState<CategoryState>,
    onCategoryAdded: (category: String) -> Unit = {},
) {
    var expanded by remember { mutableStateOf(false) }
    var categoryName by rememberSaveable { mutableStateOf("") }

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 108.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                OutlinedTextField(
                    value = categoryName,
                    onValueChange = { newCustomCategory ->
                        categoryName = newCustomCategory
                    },
                    label = { R.string.addcategory },
                    modifier = Modifier
                        .weight(0.5f)
                        .padding(end = 8.dp)
                )
                Button(
                    onClick = {

                        onCategoryAdded(categoryName)
                        categoryName = ""

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

            ExposedDropdownMenuBox(expanded = expanded,
                onExpandedChange = { expanded = it }) {

                OutlinedTextField(
                    value = state.value.selectedCategory?.categoryName ?: "",
                    onValueChange = { categoryName },
                    label = { "Kategoriyi seciniz" },
                    readOnly = true,
                    trailingIcon = {
                        ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded)
                    },
                    colors = ExposedDropdownMenuDefaults.outlinedTextFieldColors(textColor = Color.Black),
                    modifier = Modifier.menuAnchor()
                )

                ExposedDropdownMenu(
                    expanded = expanded,
                    onDismissRequest = { expanded = false }
                ) {
                    Column {
                        state.value.categories?.forEach { categoryEntity ->

                            DropdownMenuItem(text = { categoryEntity.categoryName },
                                onClick = {
                                    state.value = state.value.copy(selectedCategory = categoryEntity)
                                    expanded = false
                                }
                            )
                        }
                    }
                }
            }
        }
    }
}