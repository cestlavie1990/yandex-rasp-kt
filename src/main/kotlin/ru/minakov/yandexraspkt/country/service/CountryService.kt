package ru.minakov.yandexraspkt.country.service

import org.springframework.stereotype.Service
import ru.minakov.yandexraspkt.common.mapper.CountryMapper
import ru.minakov.yandexraspkt.common.service.AbstractService
import ru.minakov.yandexraspkt.country.graphql.type.Country
import ru.minakov.yandexraspkt.country.repository.CountryEntity
import ru.minakov.yandexraspkt.country.repository.CountryRepository
import java.util.*

@Service
class CountryService(
    override val repository: CountryRepository,
    override val mapper: CountryMapper
) : AbstractService<CountryEntity, UUID, Country>()