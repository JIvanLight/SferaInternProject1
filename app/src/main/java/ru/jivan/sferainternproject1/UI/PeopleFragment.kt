package ru.jivan.sferainternproject1.UI

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import ru.jivan.sferainternproject1.adapters.PeopleAdapter
import ru.jivan.sferainternproject1.databinding.FragmentPeopleBinding
import ru.jivan.sferainternproject1.viewModel.ViewModel

class PeopleFragment : Fragment() {

    private val viewModel: ViewModel by viewModels(ownerProducer = ::requireParentFragment)

    lateinit var binding: FragmentPeopleBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentPeopleBinding.inflate(layoutInflater, container, false)

        binding.appbarPeople.toolBarPeople.setNavigationOnClickListener {
            findNavController().navigateUp()
        }

        val adapterPeople = PeopleAdapter(viewModel)
        binding.recyclerPeople.adapter = adapterPeople
        adapterPeople.submitList(viewModel.dataPeople.value)

        return binding.root
    }
}