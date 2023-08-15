package ru.minakov.yandexraspkt.country.repository

import org.springframework.data.repository.CrudRepository
import java.util.*

interface CountryRepository : CrudRepository<CountryEntity, UUID>