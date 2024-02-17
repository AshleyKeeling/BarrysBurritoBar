package com.example.barrysburritosbar.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.barrysburritosbar.R
import com.example.barrysburritosbar.component.BurritoPreview
import com.example.barrysburritosbar.component.CustomDivider
import com.example.barrysburritosbar.data.DataSource


@Composable
fun HomeScreen(
    navOptions: List<Pair<Int, Int>>,
    OnNavOptionsClicked: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Column {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(0.3f)
            ) {
                // homepage image
                Image(
                    painter = painterResource(id = R.drawable.home_screen_banner),
                    contentDescription = "image of burrito",
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight(),
                    contentScale = ContentScale.Crop
                )
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(0.7f)
                    .padding(horizontal = 10.dp)
            ) {
                Column {
                    Spacer(modifier = Modifier.height(dimensionResource(R.dimen.padding_small)))

                    Text(
                        text = stringResource(R.string.app_name),
                        style = MaterialTheme.typography.displaySmall
                    )
                    Text(text = stringResource(R.string.home_screen_description))

                    Spacer(modifier = Modifier.height(dimensionResource(R.dimen.padding_medium)))
                    CustomDivider(MaterialTheme.colorScheme.tertiary)
                    Spacer(modifier = Modifier.height(dimensionResource(R.dimen.padding_medium)))


//                    ------- POPULAR BURRITOS SECTION ---------
                    Text(
                        text = stringResource(R.string.home_screen_subheading),
                        style = MaterialTheme.typography.headlineMedium
                    )
                    Spacer(modifier = Modifier.height(dimensionResource(R.dimen.padding_medium)))

                    Column(
                        modifier = modifier.verticalScroll(rememberScrollState())
                    ) {
                        // burrito 2 from the pre made burrito list
                        BurritoPreview(DataSource.preMadeBurritos[1])
                        Spacer(modifier = Modifier.height(dimensionResource(R.dimen.padding_medium)))
                        CustomDivider(MaterialTheme.colorScheme.onPrimaryContainer)
                        Spacer(modifier = Modifier.height(dimensionResource(R.dimen.padding_medium)))

                        // burrito 4 from the pre made burrito list
                        BurritoPreview(DataSource.preMadeBurritos[3])
                        Spacer(modifier = Modifier.height(dimensionResource(R.dimen.padding_medium)))
                        CustomDivider(MaterialTheme.colorScheme.onPrimaryContainer)
                        Spacer(modifier = Modifier.height(dimensionResource(R.dimen.padding_medium)))
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun StartOrderPreview() {
    HomeScreen(
        navOptions = DataSource.navoptions,
        OnNavOptionsClicked = { selectedOption -> println("selected: $selectedOption")},
        modifier = Modifier.fillMaxSize()
    )
}