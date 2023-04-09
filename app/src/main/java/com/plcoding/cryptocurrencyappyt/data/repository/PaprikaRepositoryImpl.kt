package com.plcoding.cryptocurrencyappyt.data.repository

import com.plcoding.cryptocurrencyappyt.data.CoinDTO
import com.plcoding.cryptocurrencyappyt.data.CoinDetailDTO
import com.plcoding.cryptocurrencyappyt.data.remote.PaprikaApi
import com.plcoding.cryptocurrencyappyt.domain.repository.PaprikaRepository
import javax.inject.Inject

class PaprikaRepositoryImpl @Inject constructor(
    private val paprikaApi: PaprikaApi
) : PaprikaRepository {

    override suspend fun getCoins(): List<CoinDTO> = paprikaApi.getCoins()

    override suspend fun getCoinById(coinId: String): CoinDetailDTO = paprikaApi.getCoinById(coinId)
}