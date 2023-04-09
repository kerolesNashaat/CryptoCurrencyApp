package com.plcoding.cryptocurrencyappyt.data


import com.google.gson.annotations.SerializedName

data class Whitepaper(
    @SerializedName("link")
    val link: String?,
    @SerializedName("thumbnail")
    val thumbnail: String?
)