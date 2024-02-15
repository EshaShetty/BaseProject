package com.eshashetty.baseproject.data

import com.eshashetty.baseproject.data.model.Stocks
import com.eshashetty.baseproject.network.APIService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class StocksRepository @Inject constructor(
    private val apiService: APIService,
    private val stockFactory: Stocks.Factory
) {
    suspend fun fetchStocks(): Flow<Result<List<Stocks>>> {

        return flow {
            val stocks = apiService.getStocks().map { stockFactory.invoke(it) }
            emit(Result.success(stocks))

        }.catch { exception ->
            emit(Result.failure(exception))
        }
    }
}