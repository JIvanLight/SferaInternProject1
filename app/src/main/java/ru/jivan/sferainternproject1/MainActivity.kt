package ru.jivan.sferainternproject1

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ru.jivan.sferainternproject1.adapters.*
import ru.jivan.sferainternproject1.databinding.FragmentMainProfileBinding

class MainActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = FragmentMainProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val listPhoto = listOf(0, 1, 2, 3)
        val listMoments = listOf(0, 1, 2 ,3, 4)
        val listChronicles = listOf(0, 1, 2, 3, 4, 5 , 6, 7, 8 ,9, 10, 11)

        val adapterPhoto = ProfilePhotoAdapter()
        binding.recyclerProfilePhoto.adapter = adapterPhoto
        adapterPhoto.submitList(listPhoto)

        val adapterMoment = ProfileMomentsAdapter()
        binding.recyclerProfileMoments.adapter = adapterMoment
        adapterMoment.submitList(listMoments)

        val gridLayoutManagerForChroniclesAdapter = object : GridLayoutManager(this, 3) {
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
    }
}