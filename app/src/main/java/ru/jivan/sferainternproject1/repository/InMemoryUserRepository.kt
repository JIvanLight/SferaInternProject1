package ru.jivan.sferainternproject1.repository

import androidx.lifecycle.MutableLiveData
import ru.jivan.sferainternproject1.data.User

class InMemoryUserRepository: UserRepository {

    override val dataPeople = MutableLiveData(
        mutableListOf(
            User(2, "Иван Иванов"),
            User(3, "Петр Петров"),
            User(1, "Сидр Сидоров"),
            User(4, "Павел Павлов")
        )
    )

    private val people
        get() = checkNotNull(dataPeople.value) {
            "Data value should not be null"
        }
}