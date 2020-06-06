package ru.kemsu.openenv.dto

import com.fasterxml.jackson.annotation.JsonProperty
import kotlinx.serialization.Serializable
import javax.validation.constraints.NotNull

@Serializable
data class OrganizationDTO(
        @field:NotNull
        @JsonProperty("name")
        val name: String,

        @field:NotNull
        @JsonProperty("id_typeServices")
        val idTypeServices: String,

        @field:NotNull
        @JsonProperty("description")
        val description: String,

        @field:NotNull
        @JsonProperty("address")
        val address: String,

        @field:NotNull
        @JsonProperty("phone")
        val phone: String,

        @field:NotNull
        @JsonProperty("site")
        val site: String,

        @field:NotNull
        @JsonProperty("time_start")
        val timeStart: Int,

        @field:NotNull
        @JsonProperty("time_end")
        val timeEnd: Int,

        @field:NotNull
        @JsonProperty("isWorkWeekend")
        val isWorkWeekend: Boolean
)