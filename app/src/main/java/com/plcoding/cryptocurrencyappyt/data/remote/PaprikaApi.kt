package com.plcoding.cryptocurrencyappyt.data.remote

import com.plcoding.cryptocurrencyappyt.data.CoinDTO
import com.plcoding.cryptocurrencyappyt.data.CoinDetailDTO
import retrofit2.http.GET
import retrofit2.http.Path

interface PaprikaApi {

    @GET("coins")
    suspend fun getCoins(): List<CoinDTO>

    @GET("coins/{coin_id}")
    suspend fun getCoinById(@Path("coin_id") coinId: String): CoinDetailDTO

}