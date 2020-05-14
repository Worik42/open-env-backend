package ru.kemsu.openenv.dto

import com.fasterxml.jackson.annotation.JsonProperty
import kotlinx.serialization.Serializable
import javax.validation.constraints.Email
import javax.validation.constraints.NotNull

@Serializable
data class UserChangeDTO(@field:NotNull
                         @field:Email
                         @JsonProperty("email")
                         val email: String,

                         @field:NotNull
                         @JsonProperty("diagnosis")
                         val diagnosis: String,

                         @JsonProperty("about")
                         val about: String

)