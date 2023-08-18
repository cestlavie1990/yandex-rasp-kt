package ru.minakov.yandexraspkt.yandex.config.properties

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.stereotype.Component

@Component
@ConfigurationProperties(prefix = "app.feign.client.yandex.rasp")
data class YandexApiProperties(
    var apiKey: String = "",
    var url: String = "",
    var connectTimeout: Long = 1000,
    var readTimeout: Long = 1000,
)