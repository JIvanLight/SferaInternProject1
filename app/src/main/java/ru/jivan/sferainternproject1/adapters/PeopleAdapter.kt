package ru.jivan.sferainternproject1.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
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

    class PeopleViewHolder(private val binding: ItemRecyclerPeopleBinding, interactionListener: UserInteractiveListener) : RecyclerView.ViewHolder(binding.root) {

        private lateinit var user: User

        private val stateButtonSub = binding.root.context.getString(R.string.subscribe)
        private val stateButtonUnsub = binding.root.context.getString(R.string.unsubscribe)

        init {
            binding.subscribeTextButton.setOnClickListener {
                when(binding.subscribeTextButton.text){
                    stateButtonSub -> binding.subscribeTextButton.text = stateButtonUnsub
                    stateButtonUnsub -> binding.subscribeTextButton.text = stateButtonSub
                }
            }
        }

        fun bind (user: User) {
            this.user = user
            binding.textviewPeople.text = user.name
        }
    }

    private object DiffCallback : DiffUtil.ItemCallback<User>() {

        override fun areItemsTheSame(oldItem: User, newItem: User): Boolean =
            oldItem == newItem

        override fun areContentsTheSame(oldItem: User, newItem: User): Boolean =
            oldItem.name == newItem.name
    }
}