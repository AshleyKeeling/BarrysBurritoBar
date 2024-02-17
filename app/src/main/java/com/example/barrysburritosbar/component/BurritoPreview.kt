package com.example.barrysburritosbar.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import com.example.barrysburritosbar.R

// displays details of a burrito (burrito is argument)
@Composable
fun BurritoPreview(burrito: List<String>) {
    Box() {
        Row {
            Column (
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(0.6f)
            ){
                // displays burrito name
                Text(text = "${burrito[0]}" , style = MaterialTheme.typography.titleLarge)
                // displays burrito ingredients
                Text(text = "Ingredients: ${burrito[1]}")
                Spacer(modifier = Modifier.height(dimensionResource(R.dimen.padding_medium)))
                // displays burrito price
                Text(text= "Price: £${burrito[2]}")

            }

            // displays burrito img
            var img = burrito[3]
            Column (
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(0.4f)
            ){
                Image(painter = painterResource(getResourceId(img)), contentDescription = "image of burrito", modifier = Modifier
                    .fillMaxWidth(),
                    contentScale = ContentScale.Crop  )
            }
        }
    }
}

// takes a string and trys to find the image with that string
fun getResourceId(imageName: String): Int {
    return try {
        R.drawable::class.java.getField(imageName).getInt(null)
    } catch (e: Exception) {
        // Handle the case where the resource ID is not found
        R.drawable.home_screen_banner
    }
}