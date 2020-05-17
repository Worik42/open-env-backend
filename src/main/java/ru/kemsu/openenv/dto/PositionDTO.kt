package ru.kemsu.openenv.dto

import com.fasterxml.jackson.annotation.JsonProperty
import kotlinx.serialization.Serializable
import javax.validation.constraints.NotNull


@Serializable
data class PositionDTO(
        @field:NotNull
        @JsonProperty("latitude")
        val latitude: Double,
        @field:NotNull
        @JsonProperty("longitude")
        val longitude: Double
)
