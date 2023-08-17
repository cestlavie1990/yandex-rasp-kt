package ru.minakov.yandexraspkt.common.service

import org.springframework.data.repository.CrudRepository
import ru.minakov.yandexraspkt.common.graphql.type.IDto
import ru.minakov.yandexraspkt.common.mapper.IMapper
import ru.minakov.yandexraspkt.common.repository.IEntity
import java.util.function.Function

interface IService<E : IEntity<ID>, ID, D : IDto> {
    val repository: CrudRepository<E, ID>
    val mapper: IMapper<E, D>

    fun <R> getOptionalById(id: ID, mapper: Function<E, R>): R?

    fun getOptionalById(id: ID): E?

    fun <R> getById(id: ID, mapper: Function<E, R>): R

    fun getById(id: ID): E

    fun <R> getAll(mapper: Function<E, R>) : Collection<R>

    fun getAll() : Collection<E>
}