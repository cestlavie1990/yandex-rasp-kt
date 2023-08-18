package ru.minakov.yandexraspkt.yandex.dto

data class SettlementDto(
    val codes: CodeDto,
    val title: String?,
    val stations: List<StationDto>
)