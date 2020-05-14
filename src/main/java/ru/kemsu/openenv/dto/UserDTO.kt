package ru.kemsu.openenv.dto

import com.fasterxml.jackson.annotation.JsonProperty
import kotlinx.serialization.Serializable
import javax.validation.constraints.Email
import javax.validation.constraints.NotNull
import javax.validation.constraints.Pattern

@Serializable
data class UserDTO(

        @field:NotNull
        @field:Email
        @JsonProperty("email")
        val username: String,

        @field:NotNull
        @JsonProperty("firstName")
        val firstName: String,

        @field:NotNull
        @JsonProperty("lastName")
        val lastName: String,

        @JsonProperty("patronymic")
        val patronymic: String,

        @field:NotNull
        @field:Pattern(regexp = "^\\s*(3[01]|[12][0-9]|0?[1-9])\\.(1[012]|0?[1-9])\\.((?:19|20)\\d{2})\\s*\$")
        @JsonProperty("dateOfBirth")
        val dateOfBirth: String,

        @JsonProperty("password")
        val password: String,

        @JsonProperty("phone")
        val phone: String

)