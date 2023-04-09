package com.plcoding.cryptocurrencyappyt.presentation

sealed class Screen(val route: String) {
    object CoinList : Screen(route = "CoinListScreen")
    object CoinDetail : Screen(route = "CoinDetailScreen")
}
