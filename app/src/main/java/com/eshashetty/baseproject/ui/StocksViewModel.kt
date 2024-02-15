package com.eshashetty.baseproject.ui

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.eshashetty.baseproject.data.StocksRepository
import com.eshashetty.baseproject.data.model.Stocks
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class StocksViewModel @Inject constructor(
    private val stocksRepository: StocksRepository
): ViewModel() {

    private val _stocks = MutableStateFlow<List<Stocks>?>(null)
    val stocks: Flow<List<Stocks>> get() = _stocks.filterNotNull()

    fun fetchStocks() {
        viewModelScope.launch {
            stocksRepository.fetchStocks().catch { exception ->
                Log.d("Stocks View Model", exception.toString())

            }.collect { result ->

                if (result.isSuccess) {
                    _stocks.value = result.getOrThrow()
                } else {
                    //error state
                }
            }
        }
    }
}