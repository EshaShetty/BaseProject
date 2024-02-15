package com.eshashetty.baseproject.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.eshashetty.baseproject.databinding.ItemViewBinding

class StockListAdapter: RecyclerView.Adapter<StockViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StockViewHolder {
        val binding = ItemViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return StockViewHolder(binding)
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: StockViewHolder, position: Int) {
        TODO("Not yet implemented")
    }
}

class StockViewHolder(binding: ItemViewBinding) : RecyclerView.ViewHolder(binding.root){

    fun onBind(){

    }
}