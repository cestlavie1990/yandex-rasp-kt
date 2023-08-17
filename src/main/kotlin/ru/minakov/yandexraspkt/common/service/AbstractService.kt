package ru.minakov.yandexraspkt.common.service

import jakarta.persistence.EntityNotFoundException
import jakarta.transaction.Transactional
import ru.minakov.yandexraspkt.common.graphql.type.IDto
import ru.minakov.yandexraspkt.common.repository.IEntity
import java.util.function.Function

abstract class AbstractService<E : IEntity<ID>, ID : Any, D : IDto> : IService<E, ID, D> {

    @Transactional
    override fun getOptionalById(id: ID): E? = getOptionalById(id, Function.identity())

    @Transactional
    override fun <R> getOptionalById(id: ID, mapper: Function<E, R>): R? =
        repository.findById(id).map(mapper).orElse(null)

    @Transactional
    override fun <R> getById(id: ID, mapper: Function<E, R>): R =
        getOptionalById(id, mapper) ?: throw entityNotFound(id).invoke()

    @Transactional
    override fun getById(id: ID): E = getById(id, Function.identity())

    @Transactional
    override fun <R> getAll(mapper: Function<E, R>): Collection<R> =
        repository.findAll().toList().stream().map(mapper).toList()

    @Transactional
    override fun getAll(): Collection<E> = getAll(Function.identity())

    protected fun entityNotFound(id: ID): () -> EntityNotFoundException {
        return { EntityNotFoundException("Entity not found by $id") }
    }
}