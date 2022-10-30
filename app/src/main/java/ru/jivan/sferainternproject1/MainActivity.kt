package ru.jivan.sferainternproject1

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ru.jivan.sferainternproject1.databinding.FragmentMainProfileBinding

class MainActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = FragmentMainProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}