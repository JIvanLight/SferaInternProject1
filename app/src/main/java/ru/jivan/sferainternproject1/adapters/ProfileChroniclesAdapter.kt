package ru.jivan.sferainternproject1.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import ru.jivan.sferainternproject1.databinding.ItemRecyclerProfileChroniclesBinding

class ProfileChroniclesAdapter() : ListAdapter<Int, ProfileChroniclesAdapter.ChroniclesViewHolder>(ProfileChroniclesAdapter.DiffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChroniclesViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemRecyclerProfileChroniclesBinding.inflate(inflater, parent, false)
        return ChroniclesViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ChroniclesViewHolder, position: Int) {
    }

    class ChroniclesViewHolder(binding: ItemRecyclerProfileChroniclesBinding): RecyclerView.ViewHolder(binding.root)

    private object DiffCallback: DiffUtil.ItemCallback<Int>(){

        override fun areItemsTheSame(oldItem: Int, newItem: Int): Boolean =
            oldItem == newItem

        override fun areContentsTheSame(oldItem: Int, newItem: Int): Boolean =
            oldItem == newItem
    }
}