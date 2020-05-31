package ru.kemsu.openenv.dto

import com.fasterxml.jackson.annotation.JsonProperty
import javax.validation.constraints.NotNull

data class UserStatusDTO(
        @field:NotNull
        @JsonProperty("claim_id")
        val idClaim: String,

        @field:NotNull
        @JsonProperty("userId")
        val userId: String,

        @JsonProperty("status")
        val status: Int
)