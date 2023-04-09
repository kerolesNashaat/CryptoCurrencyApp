package com.plcoding.cryptocurrencyappyt.presentation.coinListScreen.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.plcoding.cryptocurrencyappyt.presentation.Screen
import com.plcoding.cryptocurrencyappyt.presentation.coinListScreen.CoinsScreenVM

@Composable
fun CoinListScreen(
    navController: NavController,
    coinListVM: CoinsScreenVM = hiltViewModel()
) {
    val state = coinListVM.state.value

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
            else -> LazyColumn(modifier = Modifier
                .fillMaxSize()
                .padding(top = 30.dp)) {
                items(items = state.coins) { coin ->
                    CoinListItem(coin = coin, onItemClick = {
                        navController.navigate(route = "${Screen.CoinDetail.route}/$it")
                    })
                }
            }
        }
    }
}