package com.eshashetty.baseproject.data.model

import com.eshashetty.baseproject.network.model.StockResponse
import javax.inject.Inject

data class Stocks(
    val ticker : String,
    val name : String,
) {
    class Factory @Inject constructor() {
        fun invoke(stockResponse: StockResponse) = Stocks (
            ticker = stockResponse.ticker,
            name = stockResponse.name
        )
    }
}
