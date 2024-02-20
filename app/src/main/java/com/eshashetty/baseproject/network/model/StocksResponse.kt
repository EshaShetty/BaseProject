package com.eshashetty.baseproject.network.model

import com.google.gson.annotations.SerializedName

data class StocksResponse(
    @SerializedName("stocks")
    val stocks : List<StockResponse>,
)
