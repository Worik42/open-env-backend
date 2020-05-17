package ru.kemsu.openenv.dto

import com.fasterxml.jackson.annotation.JsonProperty
import kotlinx.serialization.Serializable
import javax.validation.constraints.NotNull

@Serializable
data class ServicesChangeDTO(
        @field:NotNull
        @JsonProperty("id_organization")
        val idOrganisation: String,

        @field:NotNull
        @JsonProperty("name")
        val name: String,

        @field:NotNull
        @JsonProperty("description")
        val description: String,

        @field:NotNull
        @JsonProperty("price")
        val price: Int,

        @field:NotNull
        @JsonProperty("time_start")
        val timeStart: Int,

        @field:NotNull
        @JsonProperty("time_start")
        val timeEnd: Int,

        @field:NotNull
        @JsonProperty("isWorkWeekend")
        val isWorkWeekend: Boolean,

        @field:NotNull
        @JsonProperty("location")
        val location: PositionDTO
)