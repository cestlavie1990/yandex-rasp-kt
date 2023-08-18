package ru.minakov.yandexraspkt.country.service

import org.springframework.stereotype.Service
import ru.minakov.yandexraspkt.common.mapper.CountryMapper
import ru.minakov.yandexraspkt.common.service.AbstractService
import ru.minakov.yandexraspkt.country.graphql.type.Country
import ru.minakov.yandexraspkt.country.repository.CountryEntity
import ru.minakov.yandexraspkt.country.repository.CountryRepository
import ru.minakov.yandexraspkt.yandex.service.YandexApiService
import java.util.*

@Service
class CountryService(
    override val repository: CountryRepository,
    override val mapper: CountryMapper,
    val apiService: YandexApiService
) : AbstractService<CountryEntity, UUID, Country>() {

    fun refreshAll(): Int {
        val dto = apiService.stationList()

        return dto.countries.size
    }
}