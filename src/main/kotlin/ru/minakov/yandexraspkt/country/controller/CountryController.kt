package ru.minakov.yandexraspkt.country.controller

import org.springframework.graphql.data.method.annotation.Argument
import org.springframework.graphql.data.method.annotation.MutationMapping
import org.springframework.graphql.data.method.annotation.QueryMapping
import org.springframework.stereotype.Controller
import ru.minakov.yandexraspkt.common.mapper.CountryMapper
import ru.minakov.yandexraspkt.country.graphql.type.Country
import ru.minakov.yandexraspkt.country.service.CountryService
import java.util.*

@Controller
class CountryController(
    val service: CountryService,
    val mapper: CountryMapper
) {

    @QueryMapping
    fun country(@Argument id: UUID): Country = service.getById(id, mapper::map)

    @QueryMapping
    fun countries(): Collection<Country> = service.getAll(mapper::map)

    @MutationMapping
    fun refreshCountries(): Int {
        throw UnsupportedOperationException("Not supported yet")
    }
}