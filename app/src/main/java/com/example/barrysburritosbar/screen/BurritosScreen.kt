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
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.barrysburritosbar.R
import com.example.barrysburritosbar.component.BurritoPreview
import com.example.barrysburritosbar.component.CustomDivider
import com.example.barrysburritosbar.data.DataSource


@Composable
fun BurritosScreen(
    navOptions: List<Pair<Int, Int>>,
    OnNavOptionsClicked: (Int) -> Unit,
    onBurritoClicked: (List<String>) -> Unit,
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current

    Column(
        modifier = modifier
            .padding(horizontal = 10.dp),
        verticalArrangement = Arrangement.SpaceBetween
    ) {

        Text(
            text = "Ready Made Burritos",
            style = MaterialTheme.typography.headlineMedium
        )
        Spacer(modifier = Modifier.height(dimensionResource(R.dimen.padding_medium)))

        Column(modifier = modifier.verticalScroll(rememberScrollState())) {
            // displays all pre made burritos, each shows name, ingredients, price, img, see more btn, add btn, favourite btn
            DataSource.preMadeBurritos.forEach{item ->

                BurritoPreview(item)
                Row (
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ){
                    // see more button (takes user to another page showing more details of the burrito)
                    Button(onClick = { onBurritoClicked(item) }, modifier = Modifier.weight(1f)) {
                        Text(text = "See more")
                    }

                    // add to order button
                    Button(onClick = {

                        val burritoValues = listOf(item[0], item[1], item[2])
                        DataSource.CurrentOrder.add(burritoValues)
                        Toast.makeText(context, "Added ${item[0]}", Toast.LENGTH_SHORT).show()
                    }, modifier = Modifier.weight(1f)) {
                        Text(text = "ADD")
                    }

                    // Favourite button (sets the burrito to there favourite burrito)
                    Button(onClick = {

                        val burritoValues = listOf(item[0], item[1], item[2])
                        DataSource.FavouriteOrder.clear()
                        DataSource.FavouriteOrder.add(burritoValues)
                        Toast.makeText(context, "Favourite: ${item[0]}", Toast.LENGTH_SHORT).show()
                    }, modifier = Modifier.weight(1f)) {
                        Text(text = "Favourite")
                    }
                }

                // divider
                Spacer(modifier = Modifier.height(dimensionResource(R.dimen.padding_medium)))
                CustomDivider(MaterialTheme.colorScheme.tertiary)
                Spacer(modifier = Modifier.height(dimensionResource(R.dimen.padding_medium)))
            }

        }
    }
}



@Preview
@Composable
fun PreviewBurritosScreen() {
    BurritosScreen(
        navOptions = DataSource.navoptions,
        OnNavOptionsClicked = { /* TODO: implement move to ChooseFlavour */ },
        onBurritoClicked = {},
        modifier = Modifier.fillMaxSize()
    )
}
