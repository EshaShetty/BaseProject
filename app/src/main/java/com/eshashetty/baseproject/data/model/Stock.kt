package com.eshashetty.baseproject.data.model

import com.eshashetty.baseproject.network.model.StockResponse
import javax.inject.Inject

data class Stock(
    val ticker : String,
    val name : String,
) {
    class Factory @Inject constructor() {
        operator fun invoke(stockResponse: StockResponse) = Stock (
            ticker = stockResponse.ticker,
            name = stockResponse.name
        )
    }
}
