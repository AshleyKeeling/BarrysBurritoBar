package com.example.barrysburritosbar.screen

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.barrysburritosbar.R
import com.example.barrysburritosbar.component.CustomDivider
import com.example.barrysburritosbar.data.DataSource
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.BufferedReader
import java.io.FileOutputStream
import java.io.IOException
import java.io.InputStreamReader

@Composable
fun BasketScreen(
    navOptions: List<Pair<Int, Int>>,
    OnNavOptionsClicked: (Int) -> Unit,
    currentOrder: List<List<String>>,
    lastOrder: List<List<String>>,
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current
    // this allows the values to update when changed
    var currentOrderState by remember { mutableStateOf(currentOrder) }
    var lastOrderState by remember { mutableStateOf(lastOrder) }

    Column(
        modifier = modifier
            .verticalScroll(rememberScrollState())
            .padding(horizontal = 10.dp),
        verticalArrangement = Arrangement.SpaceBetween
    ) {

        Row {
            Column {
                // --- Current Order -----
                Text(text = "Current Order", style = MaterialTheme.typography.headlineMedium)
                if(currentOrderState.isEmpty()) {
                    Text(text = "Order is empty")
                } else {
                    // displays all items in the current order
                    currentOrderState.forEach { item ->
                        Text(text = "Name: " + item[0], style = MaterialTheme.typography.titleLarge)
                        Text(text = "Ingredients: " + item[1])
                        Text(text = "price: £" + item[2])
                        Spacer(modifier = Modifier.height(dimensionResource(R.dimen.padding_medium)))
                    }
                }
                // place order button
                Button(onClick = {
                    if (!currentOrderState.isEmpty()) {
                        // updates last order to current order
                        DataSource.LastOrder = DataSource.CurrentOrder
                        lastOrderState = DataSource.LastOrder

                        // updates current order to empty
                        DataSource.CurrentOrder = mutableListOf()
                        currentOrderState = DataSource.CurrentOrder

                        // displays toast saying order placed
                        Toast.makeText(context, "Order placed", Toast.LENGTH_SHORT).show()
                    } else {
                        // displays toast saying order is empty
                        Toast.makeText(context, "Order is Empty!", Toast.LENGTH_SHORT).show()
                    }
                }) {
                    Text(text = "Place Order")
                }

                // divider
                Spacer(modifier = Modifier.height(dimensionResource(R.dimen.padding_medium)))
                CustomDivider(customColor = MaterialTheme.colorScheme.tertiary)
                Spacer(modifier = Modifier.height(dimensionResource(R.dimen.padding_medium)))

                // --- Favourite Order ---
                Text(text = "Favourite Order", style = MaterialTheme.typography.headlineMedium)
                DataSource.FavouriteOrder.forEach { item ->
                    Text(text = "Name: " + item[0], style = MaterialTheme.typography.titleLarge)
                    Text(text = "Ingredients: " + item[1])
                    Text(text = "price: £" + item[2])
                    Spacer(modifier = Modifier.height(dimensionResource(R.dimen.padding_medium)))
                }

                // add favourite to order button
                Button(onClick = {
                    val burritoValues = DataSource.FavouriteOrder[0]
                    DataSource.CurrentOrder.add(burritoValues)
                    currentOrderState = DataSource.CurrentOrder

                    // displays toast saying favourite is added to order
                    Toast.makeText(context, "Favourite Added to Order", Toast.LENGTH_SHORT).show()
                }) {
                    Text(text = "Add to order")
                }

                // divider
                CustomDivider(customColor = MaterialTheme.colorScheme.tertiary)
                Spacer(modifier = Modifier.height(dimensionResource(R.dimen.padding_medium)))

                // --- Last Order ---
                Text(text = "Last Order", style = MaterialTheme.typography.headlineMedium)
                // displays all items in last order
                lastOrderState.forEach { item ->
                    Text(text = "Name: " + item[0], style = MaterialTheme.typography.titleLarge)
                    Text(text = "Ingredients: " + item[1])
                    Text(text = "price: £" + item[2])
                    Spacer(modifier = Modifier.height(dimensionResource(R.dimen.padding_medium)))
                }

                // divider
                Spacer(modifier = Modifier.height(dimensionResource(R.dimen.padding_medium)))
                CustomDivider(customColor = MaterialTheme.colorScheme.tertiary)
                Spacer(modifier = Modifier.height(dimensionResource(R.dimen.padding_medium)))
            }
        }
    }
}