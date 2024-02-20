package com.eshashetty.baseproject

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.eshashetty.baseproject.databinding.MainActivityBinding
import com.eshashetty.baseproject.ui.StockListAdapter
import com.eshashetty.baseproject.ui.StocksViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity: AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: StockListAdapter
    private lateinit var binding: MainActivityBinding
    private val viewModel: StocksViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = MainActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        adapter = StockListAdapter()

        viewModel.fetchStocks()

        lifecycleScope.launch {
            viewModel.stocks.collect{
                adapter.update(it)
            }
        }

        recyclerView = binding.stockListRv
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

    }
}