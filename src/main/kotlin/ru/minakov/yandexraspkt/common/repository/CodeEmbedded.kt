package ru.minakov.yandexraspkt.common.repository

import jakarta.persistence.Column
import jakarta.persistence.Embeddable

@Embeddable
class CodeEmbedded(
    @Column var esrCode: String?,
    @Column var yandexCode: String?,
)