package com.eshashetty.baseproject.data

import android.util.Log
import com.eshashetty.baseproject.data.model.Stock
import com.eshashetty.baseproject.data.model.Stocks
import com.eshashetty.baseproject.network.APIService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class StocksRepository @Inject constructor(
    private val apiService: APIService,
    private val stocksFactory: Stocks.Factory,
    private val stockFactory: Stock.Factory
) {
    suspend fun fetchStocks(): Flow<Result<Stocks>> {
        Log.d("Repository", "before")

        return flow {
            val stocks = stocksFactory(apiService.getStocks(), stockFactory)
            Log.d("Repository", stocks.toString())
            emit(Result.success(stocks))

        }.catch { exception ->
            emit(Result.failure(exception))
            Log.d("Repository", exception.toString())
        }
    }
}