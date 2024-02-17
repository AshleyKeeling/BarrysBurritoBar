package com.example.barrysburritosbar.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.barrysburritosbar.R
import com.example.barrysburritosbar.component.getResourceId
import com.example.barrysburritosbar.data.DataSource


@Composable
fun BurritoScreenDetails(
    navOptions: List<Pair<Int, Int>>,
    OnNavOptionsClicked: (Int) -> Unit,
    burritoItem: List<String>? = listOf("", ""),
    OnBackButtonClicked: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .padding(horizontal = 10.dp),
        verticalArrangement = Arrangement.SpaceBetween
    ) {

        // displays burritos name and price
        Text(
            text = "${burritoItem?.get(0)} - £${burritoItem?.get(2)}",
            style = MaterialTheme.typography.headlineMedium
        )

        // displays burrito img
        var img = burritoItem?.get(3)
        Image(painter = painterResource(getResourceId(img)), contentDescription = "image of burrito", modifier = Modifier
                .fillMaxWidth(),
                contentScale = ContentScale.Crop
        )

        // displays burrito description
        Text(text = "Description: ${burritoItem?.get(4)}")

        // back button (takes user back to the burritos screen)
        Button(onClick = { OnBackButtonClicked(1) }) {
            Text(text = "<- Back ")
        }
        Spacer(modifier = Modifier.height(dimensionResource(R.dimen.padding_medium)))
    }
}

// takes a string and trys to find the image with that string
fun getResourceId(imageName: String?): Int {
    return try {
        if (imageName != null) {
            val resourceId = R.drawable::class.java.getField(imageName).getInt(null)
            resourceId
        } else {
            // Handle the case where imageName is null
            R.drawable.home_screen_banner
        }
    } catch (e: Exception) {
        // Handle the case where the resource ID is not found
        R.drawable.home_screen_banner
    }
}
