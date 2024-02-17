package com.example.barrysburritosbar.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

// creates a custom colored divider (color is argument)
@Composable
fun CustomDivider(customColor: Color) {
    Column(
        modifier = Modifier
        .padding(horizontal = 10.dp)


    ) {
        Divider(
            color = customColor,
            thickness = 1.dp,
            modifier = Modifier
                .fillMaxWidth(1f)
                .align(Alignment.CenterHorizontally)
        )
    }
}