package com.eshashetty.baseproject.data.model

import com.eshashetty.baseproject.network.model.StockResponse
import com.eshashetty.baseproject.network.model.StocksResponse
import javax.inject.Inject

data class Stocks(
    val stocks : List<Stock>
) {
    class Factory @Inject constructor() {
        operator fun invoke(stocksResponse: StocksResponse, stockFactory: Stock.Factory) = Stocks(
            stocks = stocksResponse.stocks.map { stockFactory(it) },
        )
    }
}
