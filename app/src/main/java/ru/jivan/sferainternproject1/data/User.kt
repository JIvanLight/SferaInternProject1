package ru.jivan.sferainternproject1.data

data class User(
    val id: Long,
    val name: String = "",
    val submits: List<User> = emptyList()
)
