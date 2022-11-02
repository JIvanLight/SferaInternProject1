package ru.jivan.sferainternproject1.viewModel

import androidx.lifecycle.ViewModel
import ru.jivan.sferainternproject1.repository.InMemoryUserRepository
import ru.jivan.sferainternproject1.repository.UserRepository

class ViewModel: ViewModel(), UserInteractiveListener {

    private val repository: UserRepository = InMemoryUserRepository()

    val dataPeople by repository::dataPeople

    override fun onPeopleClicked() {

    }


}