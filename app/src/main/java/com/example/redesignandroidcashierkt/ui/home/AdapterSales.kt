package com.example.redesignandroidcashierkt.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.redesignandroidcashierkt.R
import com.example.redesignandroidcashierkt.databinding.BillRowBinding
import com.example.redesignandroidcashierkt.pojo.ItemsModel

class AdapterSales : ListAdapter<ItemsModel, DailyClosingViewHolder>(DiffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DailyClosingViewHolder {
        val binding = DataBindingUtil.inflate<BillRowBinding>(
            LayoutInflater.from(parent.context), R.layout.bill_row, parent, false
        )
        return DailyClosingViewHolder(binding)
    }

    override fun onBindViewHolder(holder: DailyClosingViewHolder, position: Int) {
        getItem(position)?.let { holder.bind(it) }




    }

    companion object DiffCallback : DiffUtil.ItemCallback<ItemsModel>() {
        override fun areItemsTheSame(oldItem: ItemsModel, newItem: ItemsModel): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: ItemsModel, newItem: ItemsModel): Boolean {
            return oldItem.ItemID == newItem.ItemID
        }
    }




}
class DailyClosingViewHolder(private var binding: BillRowBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun bind(Item: ItemsModel) {
        binding.data = Item
        binding.executePendingBindings()
    }
}