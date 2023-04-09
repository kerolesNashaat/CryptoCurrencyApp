package com.plcoding.cryptocurrencyappyt.presentation.coinDetailScreen.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.text.font.FontStyle
import com.plcoding.cryptocurrencyappyt.data.TeamMember

@Composable
fun TeamMemberListItem(
    teamMember: TeamMember
) {
    Column(verticalArrangement = Arrangement.Top, horizontalAlignment = Alignment.Start) {
        Text(
            text = teamMember.name!!,
            style = MaterialTheme.typography.h4
        )

        Text(
            text = teamMember.position!!,
            style = MaterialTheme.typography.body2,
            fontStyle = FontStyle.Italic
        )
    }
}