package ru.jivan.sferainternproject1.repository

import androidx.lifecycle.MutableLiveData
import ru.jivan.sferainternproject1.data.User
import kotlin.random.Random

class InMemoryUserRepository : UserRepository {

    override val dataPeople = MutableLiveData(mutableListOf<User>())

    private val peoples
    get() = checkNotNull(dataPeople.value){
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
        "https://avavatar.ru/image/2768",
        "https://avavatar.ru/image/13",
        "https://avavatar.ru/image/2850",
        "https://avavatar.ru/image/2315",
        "https://avavatar.ru/image/1473",
        "https://avavatar.ru/image/3021",
        "https://avavatar.ru/image/487",
        "https://avavatar.ru/image/592",
        "https://avavatar.ru/image/1190",
        "https://avavatar.ru/image/3354"
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

    companion object{
        private const val NUMBER_OF_PEOPLE = 40
    }
}