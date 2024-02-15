package com.eshashetty.baseproject.network

import com.eshashetty.baseproject.network.model.StockResponse
import retrofit2.http.GET

interface APIService {

    @GET("/portfolio.json")
    suspend fun getStocks() : List<StockResponse>
}