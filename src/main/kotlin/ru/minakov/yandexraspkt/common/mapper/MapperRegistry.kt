package ru.minakov.yandexraspkt.common.mapper

import org.mapstruct.Mapper
import org.mapstruct.MappingConstants
import ru.minakov.yandexraspkt.country.graphql.type.Country
import ru.minakov.yandexraspkt.country.repository.CountryEntity

sealed interface IMapper<S, T> {
    fun map(source: S): T

    fun map(sources: Collection<S>): List<T> = sources.map(this::map).toList()
}


@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
sealed interface CountryMapper : IMapper<CountryEntity, Country>