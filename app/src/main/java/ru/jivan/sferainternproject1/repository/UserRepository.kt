package ru.jivan.sferainternproject1.repository

import androidx.lifecycle.LiveData
import ru.jivan.sferainternproject1.data.User

interface UserRepository {

    val dataPeople: LiveData<MutableList<User>>
}