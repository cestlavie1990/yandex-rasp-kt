package ru.minakov.yandexraspkt.country.controller

import org.springframework.graphql.data.method.annotation.Argument
import org.springframework.graphql.data.method.annotation.MutationMapping
import org.springframework.graphql.data.method.annotation.QueryMapping
import org.springframework.stereotype.Controller
import ru.minakov.yandexraspkt.country.graphql.type.Country
import java.util.*

@Controller
class CountryController {

    @QueryMapping
    fun country(@Argument id: UUID): Country {
        throw UnsupportedOperationException("Not supported yet")
    }

    @QueryMapping
    fun countries(): Collection<Country> {
        return emptyList()
    }

    @MutationMapping
    fun refreshCountries(): Int {
        throw UnsupportedOperationException("Not supported yet")
    }
}