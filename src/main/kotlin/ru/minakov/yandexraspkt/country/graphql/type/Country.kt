package ru.minakov.yandexraspkt.country.graphql.type

import ru.minakov.yandexraspkt.common.graphql.type.Code
import ru.minakov.yandexraspkt.common.graphql.type.IDto
import java.util.*

data class Country(
    val id: UUID,
    val code: Code,
    val title: String?
) : IDto