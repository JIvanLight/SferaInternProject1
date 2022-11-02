package ru.jivan.sferainternproject1.UI

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import ru.jivan.sferainternproject1.R
import ru.jivan.sferainternproject1.adapters.*
import ru.jivan.sferainternproject1.databinding.FragmentMainProfileBinding
import ru.jivan.sferainternproject1.viewModel.ViewModel

class MainProfileFragment: Fragment() {

    private lateinit var binding: FragmentMainProfileBinding
    private val viewModel: ViewModel by viewModels(ownerProducer = ::requireParentFragment)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentMainProfileBinding.inflate(layoutInflater, container, false)

        val listPhoto = listOf(0, 1, 2, 3)
        val listMoments = listOf(0, 1, 2 ,3, 4)
        val listChronicles = listOf(0, 1, 2, 3, 4, 5 , 6, 7, 8 ,9, 10, 11)

        val adapterPhoto = ProfilePhotoAdapter()
        binding.recyclerProfilePhoto.adapter = adapterPhoto
        adapterPhoto.submitList(listPhoto)

        val adapterMoment = ProfileMomentsAdapter()
        binding.recyclerProfileMoments.adapter = adapterMoment
        adapterMoment.submitList(listMoments)

        val gridLayoutManagerForChroniclesAdapter = object : GridLayoutManager(activity, 3) {
            override fun canScrollVertically(): Boolean {
                return false
            }
        }

        val dividerItemDecoration = ItemDecorationAlbumColumns(
            resources.getDimensionPixelSize(R.dimen.photos_list_spacing),
            resources.getInteger(R.integer.photo_list_preview_columns)
        )

        val adapterChronicles = ProfileChroniclesAdapter()
        binding.recyclerProfileChronicles.addItemDecoration(dividerItemDecoration)
        binding.recyclerProfileChronicles.layoutManager = gridLayoutManagerForChroniclesAdapter
        binding.recyclerProfileChronicles.adapter = adapterChronicles
        adapterChronicles.submitList(listChronicles)

        binding.peopleButton.setOnClickListener {
            findNavController().navigate(R.id.action_mainProfileFragment_to_peopleFragment)
        }

        return binding.root
    }

}