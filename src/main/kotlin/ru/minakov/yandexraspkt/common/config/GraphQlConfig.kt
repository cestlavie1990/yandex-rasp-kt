package ru.minakov.yandexraspkt.common.config

import graphql.scalars.ExtendedScalars
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.graphql.execution.RuntimeWiringConfigurer

@Configuration
class GraphQlConfig {

    @Bean
    fun runtimeWiringConfigurer(): RuntimeWiringConfigurer {
        return RuntimeWiringConfigurer { builder ->
            builder.scalar(ExtendedScalars.UUID).scalar(ExtendedScalars.Date).scalar(ExtendedScalars.DateTime)
        }
    }
}