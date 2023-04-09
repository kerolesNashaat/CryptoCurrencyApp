package com.plcoding.cryptocurrencyappyt.presentation.coinDetailScreen.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.google.accompanist.flowlayout.FlowRow
import com.plcoding.cryptocurrencyappyt.R
import com.plcoding.cryptocurrencyappyt.data.TeamMember
import com.plcoding.cryptocurrencyappyt.presentation.coinDetailScreen.CoinDetailVM

@Composable
fun CoinDetailScreen(
    coinDetailVM: CoinDetailVM = hiltViewModel()
) {
    val state = coinDetailVM.state.value

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp)
    ) {
        when {
            state.isLoading -> {
                CircularProgressIndicator(
                    modifier = Modifier
                        .align(Alignment.Center)
                )
            }
            !state.error.isNullOrBlank() -> {
                Box(
                    modifier = Modifier
                        .align(Alignment.Center)
                ) {
                    Text(
                        text = state.error,
                        color = MaterialTheme.colors.error,
                        style = MaterialTheme.typography.h2
                    )
                }
            }
            state.coinDetail != null -> {
                LazyColumn(Modifier.fillMaxSize()) {
                    item {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(top = 20.dp),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            val coin = state.coinDetail
                            Text(
                                text = "${coin.rank.toString()}. ${coin.name} (${coin.symbol})",
                                overflow = TextOverflow.Ellipsis,
                                style = MaterialTheme.typography.h2
                            )

                            Text(
                                text = if (coin.isActive == true) "active" else "inactive",
                                color = if (coin.isActive == true) Color.Green else Color.Red,
                                fontStyle = FontStyle.Italic,
                                style = MaterialTheme.typography.body2
                            )
                        }

                        Spacer(modifier = Modifier.height(15.dp))
                        Text(
                            text = state.coinDetail.description!!,
                            style = MaterialTheme.typography.body2
                        )
                        Spacer(modifier = Modifier.height(15.dp))
                    }

                    item {
                        Text(
                            text = stringResource(id = R.string.tags),
                            style = MaterialTheme.typography.h2
                        )
                        Spacer(modifier = Modifier.height(15.dp))

                        FlowRow {
                            state.coinDetail.tags?.forEach { tag ->
                                TagChip(tag = tag!!)
                            }
                        }

                        Spacer(modifier = Modifier.height(15.dp))
                    }

                    item {
                        Text(
                            text = stringResource(id = R.string.team_members),
                            style = MaterialTheme.typography.h2
                        )
                        Spacer(modifier = Modifier.height(15.dp))
                    }

                    items(items = state.coinDetail.team!!) { teamMember: TeamMember? ->
                        Box(modifier = Modifier.padding(vertical = 10.dp)) {
                            TeamMemberListItem(teamMember!!)
                        }
                    }
                }
            }
        }
    }
}