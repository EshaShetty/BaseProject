package com.eshashetty.baseproject.network.model

import com.google.gson.annotations.SerializedName

data class StockResponse(
    @SerializedName("ticker")
    val ticker : String,
    @SerializedName("name")
    val name : String,
    @SerializedName("currency")
    val currency: Int,
    @SerializedName("current_price_cents")
    val priceCent: Int,
    @SerializedName("quantity")
    val quantity: Int?,
    @SerializedName("current_price_timestamp")
    val priceTimeStamp: Int
)
