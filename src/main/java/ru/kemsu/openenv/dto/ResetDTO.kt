package ru.kemsu.openenv.dto

import com.fasterxml.jackson.annotation.JsonProperty
import javax.validation.constraints.NotNull

data class ResetDTO(

        @field:NotNull
        @JsonProperty("new_password")
        val newPassword: String

)