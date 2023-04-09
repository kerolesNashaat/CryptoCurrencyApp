package com.plcoding.cryptocurrencyappyt.presentation.coinDetailScreen

import com.plcoding.cryptocurrencyappyt.domain.model.CoinDetail

data class CoinDetailStates(
    val isLoading: Boolean = false,
    val coinDetail: CoinDetail? = null,
    val error: String? = null
)
