package ru.kemsu.openenv.dto

import com.fasterxml.jackson.annotation.JsonProperty
import kotlinx.serialization.Serializable

@Serializable
data class UserDTO(
        @JsonProperty("firstName")
        val firstName: String,
        @JsonProperty("lastName")
        val lastName: String,
        @JsonProperty("patronymic")
        val patronymic: String,
        @JsonProperty("dateOfBirth")
        val dateOfBirth: String,
        @JsonProperty("password")
        val password: String,
        @JsonProperty("phone")
        val phone: String

)