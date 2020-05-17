package ru.kemsu.openenv.dto

import com.fasterxml.jackson.annotation.JsonProperty
import kotlinx.serialization.Serializable
import javax.validation.constraints.NotNull

@Serializable
data class ClaimDTO(
        @field:NotNull
        @JsonProperty("id_service")
        val idService: String,

        @field:NotNull
        @JsonProperty("time_start")
        val timeStart: String,

        @JsonProperty("description")
        val description: String

)