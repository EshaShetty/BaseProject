package com.eshashetty.baseproject.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.eshashetty.baseproject.data.model.Stock
import com.eshashetty.baseproject.data.model.Stocks
import com.eshashetty.baseproject.databinding.ItemViewBinding

class StockListAdapter: RecyclerView.Adapter<StockViewHolder>() {

    private var list = Stocks(emptyList())
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StockViewHolder {
        val binding = ItemViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return StockViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return list.stocks.size
    }

    override fun onBindViewHolder(holder: StockViewHolder, position: Int) {
        holder.onBind(list.stocks[position])
    }

    fun update(newList: Stocks) {
        list = newList
        notifyDataSetChanged()
    }
}

class StockViewHolder(private val binding: ItemViewBinding) : RecyclerView.ViewHolder(binding.root){

    fun onBind(item: Stock){
        binding.stockNameTv.text = item.name
        binding.stockTickerTv.text = item.ticker
    }
}