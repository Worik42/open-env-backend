package ru.kemsu.openenv.dto

import com.fasterxml.jackson.annotation.JsonProperty
import kotlinx.serialization.ContextualSerialization
import kotlinx.serialization.Serializable
import org.springframework.format.annotation.DateTimeFormat
import java.util.*
import javax.validation.constraints.NotNull

@Serializable
data class ClaimDTO(
        @field:NotNull
        @JsonProperty("id_service")
        val idService: String,

        @field:NotNull
        @DateTimeFormat(pattern = "dd.MM.yyyy HH:mm:ss")
        @JsonProperty("time_start")
        val timeStart: @ContextualSerialization Date,

        @JsonProperty("description")
        val description: String

)