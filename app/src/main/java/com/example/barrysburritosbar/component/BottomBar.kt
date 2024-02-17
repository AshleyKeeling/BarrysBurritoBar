package com.example.barrysburritosbar.component

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.BottomAppBarDefaults
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.barrysburritosbar.component.NavButton
import com.example.barrysburritosbar.data.DataSource



@Composable
fun NavButton(
    @StringRes labelResourceId: Int,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    TextButton(
        onClick = { onClick() },
        modifier = modifier.widthIn(max = 100.dp).padding(0.dp)
            .fillMaxWidth()
    ) {
        Text(stringResource(labelResourceId))
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BarrysBurritoBarBottomBar(
    navOptions: List<Pair<Int, Int>>,
    OnNavOptionsClicked: (Int) -> Unit,
    modifier: Modifier = Modifier

) {
    BottomAppBar(
        containerColor = MaterialTheme.colorScheme.primaryContainer,
        content = {

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                // displays button for each nav page
                DataSource.navoptions.forEach { item ->
                    NavButton(
                        labelResourceId = item.first,
                        onClick = { OnNavOptionsClicked(item.second) },
                        modifier = Modifier.weight(1f)

                    )
                }
            }
        }
    )
}