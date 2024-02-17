package com.example.barrysburritosbar.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import com.example.barrysburritosbar.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BarrysBurritosBarAppBar(
    modifier: Modifier = Modifier
) {
    TopAppBar(
        colors = TopAppBarDefaults.mediumTopAppBarColors(containerColor = MaterialTheme.colorScheme.primaryContainer),
        title = {
            Column(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.padding_small))
            ) {
                Text(
                    text = stringResource(R.string.app_name),
                )
                Text(
                    text = stringResource(R.string.established_name),
                )
            }
        }
    )
}
