package com.plcoding.cryptocurrencyappyt.data

import com.google.gson.annotations.SerializedName
import com.plcoding.cryptocurrencyappyt.domain.model.Coin

data class CoinDTO(
    @SerializedName("id")
    val id: String?,
    @SerializedName("is_active")
    val isActive: Boolean?,
    @SerializedName("is_new")
    val isNew: Boolean?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("rank")
    val rank: Int?,
    @SerializedName("symbol")
    val symbol: String?,
    @SerializedName("type")
    val type: String?
)

fun CoinDTO.toCoin() = Coin(
    id = id,
    isActive = isActive,
    isNew = isNew,
    name = name,
    rank = rank,
    symbol = symbol,
    type = type
)