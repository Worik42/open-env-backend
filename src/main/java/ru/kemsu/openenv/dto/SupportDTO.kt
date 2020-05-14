package ru.kemsu.openenv.dto

import com.fasterxml.jackson.annotation.JsonProperty
import kotlinx.serialization.Serializable
import javax.validation.constraints.NotNull

@Serializable
data class SupportDTO(

        @field:NotNull
        @JsonProperty("title")
        val title: String,

        @field:NotNull
        @JsonProperty("text")
        val text: String

)