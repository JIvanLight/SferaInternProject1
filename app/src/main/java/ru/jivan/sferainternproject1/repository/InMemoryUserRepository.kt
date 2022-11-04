package ru.jivan.sferainternproject1.repository

import androidx.lifecycle.MutableLiveData
import ru.jivan.sferainternproject1.data.User
import kotlin.random.Random

class InMemoryUserRepository : UserRepository {

    override val dataPeople = MutableLiveData(mutableListOf<User>())

    private val peoples
        get() = checkNotNull(dataPeople.value) {
            "The peoples cannot be null."
        }

    private val nameList = listOf(
        "Снежана Иванова",
        "Валерия Петрова",
        "Катя Сидорова",
        "София Павлова",
        "Ульяна Семенова",
        "Антонина Петрова",
        "Мария Иванова",
        "Ольга Киреева",
        "Янина Клюквина"
    )

    private val linkList = listOf(
        "https://avavatar.ru/images/original/3/Co8cw3ZCRV4Uk6Qm.jpg",
        "https://avavatar.ru/images/original/1/dBKV5jOXviPT7ewq.jpg",
        "https://avavatar.ru/images/original/3/nJzhDoDwyV0Kzkvx.jpg",
        "https://avavatar.ru/images/original/3/CUfro1kBxZxkMyOQ.jpg",
        "https://avavatar.ru/images/original/2/MucWNLAKhmOjgpFK.jpg",
        "https://avavatar.ru/images/original/3/bX4pOZxIH6QezdDl.jpg",
        "https://avavatar.ru/images/full/1/73yPZbXKbqyU34mB.jpg",
        "https://avavatar.ru/images/original/1/K4ny9j76HOS0cP5s.jpg",
        "https://avavatar.ru/images/full/2/6Kca85E1PNv6dJf3.jpg",
        "https://avavatar.ru/images/original/4/rzSGbLvw50hgxDWq.jpg"
    )

    init {
        peoples.addAll(completeUserList(nameList, linkList, NUMBER_OF_PEOPLE))
    }

    private fun completeUserList(names: List<String>, links: List<String>, size: Int): List<User> {
        val users = emptyList<User>().toMutableList()
        for (i in 1..size) {
            users.add(
                User(
                    name = names[Random.nextInt(names.size)],
                    linkAvatar = links[Random.nextInt(links.size)]
                )
            )
        }
        return users
    }

    companion object {
        private const val NUMBER_OF_PEOPLE = 40
    }
}