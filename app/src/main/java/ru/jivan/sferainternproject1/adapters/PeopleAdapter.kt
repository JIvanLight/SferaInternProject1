package ru.jivan.sferainternproject1.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import ru.jivan.sferainternproject1.R
import ru.jivan.sferainternproject1.data.User
import ru.jivan.sferainternproject1.databinding.ItemRecyclerPeopleBinding
import ru.jivan.sferainternproject1.viewModel.UserInteractiveListener

class PeopleAdapter(private val interactionListener: UserInteractiveListener) :
    ListAdapter<User, PeopleAdapter.PeopleViewHolder>(DiffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PeopleViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemRecyclerPeopleBinding.inflate(inflater, parent, false)
        return PeopleViewHolder(binding, interactionListener)
    }

    override fun onBindViewHolder(holder: PeopleViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class PeopleViewHolder(
        private val binding: ItemRecyclerPeopleBinding,
        interactionListener: UserInteractiveListener
    ) : RecyclerView.ViewHolder(binding.root) {

        private lateinit var user: User

        private val context = binding.root.context
        private val stateTextButtonSub = context.getString(R.string.subscribe)
        private val stateTextButtonUnsub = context.getString(R.string.unsubscribe)
        private val stateTextColorButtonSub = context.getColor(R.color.on_primary)
        private val stateTextColorButtonUnsub = context.getColor(R.color.on_surface_medium_emphasis)

        init {
            binding.subscribeTextButton.setOnClickListener {
                when (binding.subscribeTextButton.text) {
                    stateTextButtonSub -> {
                        binding.subscribeTextButton.text = stateTextButtonUnsub
                        binding.subscribeTextButton.setTextColor(stateTextColorButtonUnsub)
                    }
                    stateTextButtonUnsub -> {
                        binding.subscribeTextButton.text = stateTextButtonSub
                        binding.subscribeTextButton.setTextColor(stateTextColorButtonSub)
                    }
                }
            }
        }

        fun bind(user: User) {
            this.user = user
            binding.textviewPeople.text = user.name
            Glide.with(context)
                .load(user.linkAvatar)
                .skipMemoryCache(true)
                .centerCrop()
                .diskCacheStrategy(DiskCacheStrategy.NONE)
                .placeholder(context.resources.getDrawable(R.drawable.place_holder, context.theme))
                .error(context.resources.getDrawable(R.drawable.place_holder, context.theme))
                .into(binding.avatarPeople)
        }
    }

    private object DiffCallback : DiffUtil.ItemCallback<User>() {

        override fun areItemsTheSame(oldItem: User, newItem: User): Boolean =
            oldItem == newItem

        override fun areContentsTheSame(oldItem: User, newItem: User): Boolean =
            oldItem.name == newItem.name
    }
}