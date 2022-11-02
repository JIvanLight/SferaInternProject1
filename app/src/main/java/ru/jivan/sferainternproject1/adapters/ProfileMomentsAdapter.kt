package ru.jivan.sferainternproject1.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import ru.jivan.sferainternproject1.databinding.ItemRecyclerProfileMomentsBinding

class ProfileMomentsAdapter() : ListAdapter<Int, ProfileMomentsAdapter.MomentsViewHolder>(DiffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MomentsViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemRecyclerProfileMomentsBinding.inflate(inflater, parent, false)
        return MomentsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MomentsViewHolder, position: Int) {
    }

    class MomentsViewHolder(binding: ItemRecyclerProfileMomentsBinding): RecyclerView.ViewHolder(binding.root)

    private object DiffCallback: DiffUtil.ItemCallback<Int>(){

        override fun areItemsTheSame(oldItem: Int, newItem: Int): Boolean =
            oldItem == newItem

        override fun areContentsTheSame(oldItem: Int, newItem: Int): Boolean =
            oldItem == newItem
    }
}