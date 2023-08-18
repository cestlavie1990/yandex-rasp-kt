package ru.minakov.yandexraspkt.yandex.service

import org.springframework.stereotype.Service
import ru.minakov.yandexraspkt.yandex.config.properties.YandexApiProperties
import ru.minakov.yandexraspkt.yandex.dto.StationListDto

@Service
class YandexApiService(
    val api: YandexApi,
    val props: YandexApiProperties,
) {
    fun stationList(): StationListDto = api.stationList(props.apiKey, YandexApi.DEFAULT_LANG, YandexApi.DEFAULT_JSON)
}