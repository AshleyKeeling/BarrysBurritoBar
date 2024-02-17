package com.example.barrysburritosbar.screen

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.barrysburritosbar.component.CustomDivider
import com.example.barrysburritosbar.data.DataSource


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomBurritoScreen(
    navOptions: List<Pair<Int, Int>>,
    OnNavOptionsClicked: (Int) -> Unit,
    modifier: Modifier = Modifier

) {
    var customBurritoPrice by remember { mutableStateOf(3.00) }
    var customBurritoName by remember { mutableStateOf("") }
    var selectedMainFilling by remember { mutableStateOf(0) }
    var checkedAdditionalFillingsStates by remember { mutableStateOf(List(DataSource.fillingOptions.size) { false }) }
    var checkedSaucesStates by remember { mutableStateOf(List(DataSource.sauceOptions.size) { false }) }
    var checkedSaladStates by remember { mutableStateOf(List(DataSource.saladOptions.size) { false }) }

    val context = LocalContext.current

    Column(
        modifier = modifier
            .padding(horizontal = 10.dp)
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Row {
            Column {
                Text(
                    text = "Custom Burrito - £${"%.2f".format(customBurritoPrice)}",
                    style = MaterialTheme.typography.headlineMedium
                )

                // --- BURRITO NAME ---
                Text(text = "Burrito Name: ", style = MaterialTheme.typography.titleLarge)

                TextField(
                    value = customBurritoName,
                    onValueChange = { customBurritoName = it },
                    placeholder = { Text(text = "Burrito name...") },
                    modifier = Modifier.fillMaxWidth()
                )

                // --- MAIN FILLINGS ---
                Text(text = "Main Filling:", style = MaterialTheme.typography.titleLarge)
                Spacer(modifier = Modifier.height(8.dp))

                // displays all the main filling options
                DataSource.fillingOptions.forEach { item ->
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        RadioButton(
                            selected = selectedMainFilling == item.second,
                            onClick = { selectedMainFilling = item.second },
                        )
                        Text(
                            text = item.first,
                            style = MaterialTheme.typography.bodyMedium,
                            modifier = Modifier.padding(start = 8.dp)
                        )
                    }
                }

                // --- ADDITIONAL FILLINGS ---
                Text(
                    text = "Additional Filling (£2 each):",
                    style = MaterialTheme.typography.titleLarge
                )

                // displays all the filling options
                DataSource.fillingOptions.forEach { item ->
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Checkbox(
                            checked = checkedAdditionalFillingsStates[item.second],
                            onCheckedChange = {
                                checkedAdditionalFillingsStates =
                                    checkedAdditionalFillingsStates.toMutableList().apply {
                                        set(item.second, it)
                                    }
                                // Update the customBurritoPrice based on the checkbox state
                                customBurritoPrice += if (it) 2.00 else -2.00
                            }
                        )
                        Text(text = item.first)
                    }
                }

                // --- SAUCES OPTIONS ---
                Text(text = "Sauces (£1.50 each):", style = MaterialTheme.typography.titleLarge)
                // displays all the sauce options
                DataSource.sauceOptions.forEach { item ->
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Checkbox(
                            checked = checkedSaucesStates[item.second],
                            onCheckedChange = {
                                checkedSaucesStates =
                                    checkedSaucesStates.toMutableList().apply {
                                        set(item.second, it)
                                    }
                                // Update the customBurritoPrice based on the checkbox state
                                customBurritoPrice += if (it) 1.50 else -1.50
                            }
                        )
                        Text(text = item.first)
                    }
                }

                // --- SALAD OPTIONS ---
                Text(text = "Salad Options (£1 each):", style = MaterialTheme.typography.titleLarge)
                // displays all the salad options
                DataSource.saladOptions.forEach { item ->
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Checkbox(
                            checked = checkedSaladStates[item.second],
                            onCheckedChange = {
                                checkedSaladStates =
                                    checkedSaladStates.toMutableList().apply {
                                        set(item.second, it)
                                    }
                                // Update the customBurritoPrice based on the checkbox state
                                customBurritoPrice += if (it) 1.00 else -1.00
                            }
                        )
                        Text(text = item.first)
                    }
                }

                // divider
                CustomDivider(customColor = MaterialTheme.colorScheme.onPrimaryContainer)

                // gets all the data the user has entered/selected
                val mainFilling = DataSource.fillingOptions[selectedMainFilling].first
                // filter the fillings list by the list of checkboxes (bools) that are true
                val additionalFillings = DataSource.fillingOptions.filterIndexed { index, _ ->
                    checkedAdditionalFillingsStates.getOrNull(index) == true
                }.map { it.first }
                val sauces = DataSource.sauceOptions.filterIndexed { index, _ ->
                    checkedSaucesStates.getOrNull(index) == true
                }.map { it.first }
                val saladOptions = DataSource.saladOptions.filterIndexed { index, _ ->
                    checkedSaladStates.getOrNull(index) == true
                }.map { it.first }
                val allSelectedOptions =
                    listOfNotNull(mainFilling) + additionalFillings + sauces + saladOptions


                Row {
                    Column {
                        // reset form button
                        Button(onClick = {
                            customBurritoPrice = (3.00)
                            customBurritoName = ("")
                            selectedMainFilling = (0)
                            checkedAdditionalFillingsStates = (List(DataSource.fillingOptions.size) { false })
                            checkedSaucesStates = (List(DataSource.sauceOptions.size) { false })
                            checkedSaladStates = (List(DataSource.saladOptions.size) { false })
                        }) {
                            Text(text ="Reset Form")
                        }
                    }
                    Column {
                        // favourite button
                        Button(onClick = {
                            if (customBurritoName != "") {
                                val burritoValues = listOf(
                                    "$customBurritoName",
                                    "$allSelectedOptions",
                                    "${"%.2f".format(customBurritoPrice)}"
                                )
                                DataSource.FavouriteOrder.clear()
                                DataSource.FavouriteOrder.add(burritoValues)
                                Toast.makeText(
                                    context,
                                    "Favourite: ${customBurritoName}",
                                    Toast.LENGTH_SHORT
                                ).show()
                            } else {
                                Toast.makeText(context,"Enter Name!", Toast.LENGTH_SHORT).show()
                            }
                        }) {
                            Text(text ="Favourite")
                        }
                    }

                    // displays add to order button
                    Column (modifier = Modifier.weight(0.6f)) {
                        AddToOrder(customBurritoName, allSelectedOptions, customBurritoPrice)
                    }
                }
            }
        }
    }
}

// add to order button
@Composable
fun AddToOrder(
    customBurritoName: String,
    allSelectedOptions: List<String>,
    customBurritoPrice: Double
) {
    var showDialog by remember { mutableStateOf(false) }
    val context = LocalContext.current

    Button(onClick = {
        if(customBurritoName == "") {
            showDialog = false
            Toast.makeText(context, "Enter Name!", Toast.LENGTH_SHORT).show()

        }
        else {
            showDialog = true
        }
        }, modifier = Modifier.fillMaxWidth()) {
        Text("Add To Order")
    }

    if (showDialog) {
        AlertDialog(
            onDismissRequest = {
                // Handle dismiss action
                showDialog = false
            },
            title = {
                Text(text = "Added to Order")
            },
            text = {
                Text(text = "Name: $customBurritoName\nIngredients: $allSelectedOptions \nPrice: £${"%.2f".format(customBurritoPrice)}")
            },
            confirmButton = {
                TextButton(
                    onClick = {
                        // Handle confirm action
                        showDialog = false

                        // save data
                        val customBurritoDetails = listOf("$customBurritoName", "$allSelectedOptions", "${"%.2f".format(customBurritoPrice)}")
                        DataSource.CurrentOrder.add(customBurritoDetails)
                    }
                ) {
                    Text("OK")
                }
            },
            dismissButton = {
                TextButton(
                    onClick = {
                        // Handle dismiss action
                        showDialog = false
                    }
                ) {
                    Text("Cancel")
                }
            }
        )
    }
}

@Preview
@Composable
fun PreviewCustomBurritoScreen() {
    CustomBurritoScreen(
        navOptions = DataSource.navoptions,
        OnNavOptionsClicked = { /* TODO*/ },
        modifier = Modifier.fillMaxSize()
    )
}
