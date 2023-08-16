package ru.minakov.yandexraspkt.country.repository

import jakarta.persistence.*
import ru.minakov.yandexraspkt.common.repository.CodeEmbedded
import ru.minakov.yandexraspkt.common.repository.IEntity
import java.time.OffsetDateTime
import java.util.*

@Entity
@Table(name = "country")
class CountryEntity(
    @Id @GeneratedValue @Column(updatable = false) override var id: UUID,
    @Embedded var code: CodeEmbedded,
    @Column var title: String?,
    @Column(nullable = false) var createdAt: OffsetDateTime,
    @Column(nullable = false) var updatedAt: OffsetDateTime
) : IEntity<UUID>