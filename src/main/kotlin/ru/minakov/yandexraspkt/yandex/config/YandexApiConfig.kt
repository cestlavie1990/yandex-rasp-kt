package ru.minakov.yandexraspkt.yandex.config

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.PropertyNamingStrategies
import com.fasterxml.jackson.databind.SerializationFeature
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule
import com.fasterxml.jackson.module.paramnames.ParameterNamesModule
import feign.Feign
import feign.Request
import feign.jackson.JacksonDecoder
import feign.jackson.JacksonEncoder
import feign.okhttp.OkHttpClient
import feign.slf4j.Slf4jLogger
import org.springframework.cloud.openfeign.support.SpringMvcContract
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import ru.minakov.yandexraspkt.yandex.config.properties.YandexApiProperties
import ru.minakov.yandexraspkt.yandex.service.YandexApi
import java.util.concurrent.TimeUnit

@Configuration
class YandexApiConfig {

    @Bean
    fun yandexApi(props: YandexApiProperties): YandexApi {
        val mapper = mapper()

        return Feign.builder()
            .client(OkHttpClient())
            .encoder(JacksonEncoder(mapper))
            .decoder(JacksonDecoder(mapper))
            .options(
                Request.Options(
                    props.connectTimeout,
                    TimeUnit.MILLISECONDS,
                    props.readTimeout,
                    TimeUnit.MILLISECONDS,
                    true
                )
            )
            .logger(Slf4jLogger(YandexApi::class.java))
            .contract(SpringMvcContract())
            .target(YandexApi::class.java, props.url)
    }

    private fun mapper(): ObjectMapper {
        val mapper = ObjectMapper()
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL)
        mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false)
        mapper.configure(DeserializationFeature.ADJUST_DATES_TO_CONTEXT_TIME_ZONE, false)
        mapper.configure(DeserializationFeature.ACCEPT_FLOAT_AS_INT, false)
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
        mapper.propertyNamingStrategy = PropertyNamingStrategies.SnakeCaseStrategy()
        mapper.registerModules(Jdk8Module(), JavaTimeModule(), ParameterNamesModule())
        return mapper
    }
}