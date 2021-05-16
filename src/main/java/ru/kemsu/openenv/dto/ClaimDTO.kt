package ru.kemsu.openenv.dto

import com.fasterxml.jackson.annotation.JsonFormat
import com.fasterxml.jackson.annotation.JsonProperty
import kotlinx.serialization.Contextual
import kotlinx.serialization.Serializable
import java.util.*
import javax.validation.constraints.NotNull

@Serializable
data class ClaimDTO(
        @field:NotNull
        @JsonProperty("id_service")
        val idService: String,

        @field:NotNull
        @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
        val time: @Contextual Date,

        @JsonProperty("description")
        val description: String

)