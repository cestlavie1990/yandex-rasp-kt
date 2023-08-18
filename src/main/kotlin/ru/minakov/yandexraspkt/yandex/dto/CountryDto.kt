package ru.minakov.yandexraspkt.yandex.dto

data class CountryDto(
    val codes: CodeDto,
    val title: String?,
    val regions: List<RegionDto>
)