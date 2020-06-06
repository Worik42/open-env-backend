package ru.kemsu.openenv.dto


import com.fasterxml.jackson.annotation.JsonProperty
import kotlinx.serialization.Serializable
import javax.validation.constraints.NotNull

@Serializable
data class TypeServiceDTO(
        @field:NotNull
        @JsonProperty("name")
        var name: String
)