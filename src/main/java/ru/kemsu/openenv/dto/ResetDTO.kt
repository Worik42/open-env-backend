package ru.kemsu.openenv.dto

import com.fasterxml.jackson.annotation.JsonProperty
import kotlinx.serialization.Serializable
import javax.validation.constraints.NotNull

@Serializable
data class ResetDTO(

        @field:NotNull
        @JsonProperty("new_password")
        val newPassword: String

)