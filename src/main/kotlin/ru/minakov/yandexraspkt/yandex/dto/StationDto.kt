package ru.minakov.yandexraspkt.yandex.dto

data class StationDto(
    val codes: CodeDto,
    val title: String?,
    val direction: String?,
    val stationType: String?,
    val transportType: String?,
    val latitude: Double?,
    val longitude: Double?,
)