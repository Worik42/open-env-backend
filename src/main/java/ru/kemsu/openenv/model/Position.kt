package ru.kemsu.openenv.model

import java.io.Serializable


data class Position(
        var latitude: Double,
        var longitude: Double
) : BaseEntity(), Serializable