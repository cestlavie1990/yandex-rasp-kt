package ru.minakov.yandexraspkt.yandex.dto

data class RegionDto(
    val codes: CodeDto,
    val title: String?,
    val settlements: List<SettlementDto>
)