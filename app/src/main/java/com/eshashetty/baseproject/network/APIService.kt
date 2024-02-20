package com.eshashetty.baseproject.network

import com.eshashetty.baseproject.network.model.StockResponse
import com.eshashetty.baseproject.network.model.StocksResponse
import retrofit2.http.GET

interface APIService {

    @GET("portfolio.json")
    suspend fun getStocks() : StocksResponse
}