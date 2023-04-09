package com.plcoding.cryptocurrencyappyt.presentation.coinListScreen

import com.plcoding.cryptocurrencyappyt.domain.model.Coin

data class CoinsScreenStates(
    val isLoading: Boolean = false,
    val coins: List<Coin> = listOf(),
    val error: String? = null
)
