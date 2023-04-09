package com.plcoding.cryptocurrencyappyt.presentation.coinListScreen.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.plcoding.cryptocurrencyappyt.domain.model.Coin

@Composable
fun coinListItem(
    coin: Coin,
    onItemClick: (coinId: String?) -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
            .clickable {
                onItemClick(coin.id)
            }
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "${coin.rank.toString()}. ${coin.name} (${coin.symbol})",
                overflow = TextOverflow.Ellipsis
            )

            Text(
                text = if (coin.isActive == true) "active" else "inactive",
                color = if (coin.isActive == true) Color.Green else Color.Red,
                fontStyle = FontStyle.Italic,
                style = MaterialTheme.typography.body2
            )
        }
    }
}