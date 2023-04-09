package com.plcoding.cryptocurrencyappyt.domain.repository

import com.plcoding.cryptocurrencyappyt.data.CoinDTO
import com.plcoding.cryptocurrencyappyt.data.CoinDetailDTO

interface PaprikaRepository {

    suspend fun getCoins(): List<CoinDTO>

    suspend fun getCoinById(coinId: String): CoinDetailDTO
}