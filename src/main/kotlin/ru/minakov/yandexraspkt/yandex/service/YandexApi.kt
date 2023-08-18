package ru.minakov.yandexraspkt.yandex.service

import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestHeader
import org.springframework.web.bind.annotation.RequestParam
import ru.minakov.yandexraspkt.yandex.dto.StationListDto

interface YandexApi {

    @GetMapping(value = ["stations_list"], consumes = [MediaType.APPLICATION_JSON_VALUE])
    fun stationList(
        @RequestHeader(AUTH_HEADER) auth: String,
        @RequestParam(name = "lang", required = false, defaultValue = DEFAULT_LANG) lang: String,
        @RequestParam(name = "format", required = false, defaultValue = DEFAULT_JSON) format: String
    ): StationListDto

    companion object {
        private const val AUTH_HEADER = "Authorization"
        private const val DEFAULT_LANG = "ru_RU"
        private const val DEFAULT_JSON = "json"
    }
}