package com.plcoding.cryptocurrencyappyt.presentation.coinDetailScreen.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.plcoding.cryptocurrencyappyt.data.Tag

@Composable
fun TagChip(
    tag: Tag
) {
    Surface(
        modifier = Modifier.padding(end = 8.dp, bottom = 8.dp),
        elevation = 8.dp,
        shape = RoundedCornerShape(16.dp),
        border = BorderStroke(
            width = 1.dp,
            color = Color.Green
        )
    ) {
        Text(
            text = tag.name!!, color = Color.Green,
            style = MaterialTheme.typography.body2,
            modifier = Modifier.padding(10.dp)
        )
    }
}