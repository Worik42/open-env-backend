package ru.kemsu.openenv.model

import java.io.Serializable


data class Position(
        private var latitude: Double,
        private var longitude: Double
) : BaseEntity(), Serializable