package ru.kemsu.openenv.dto

import kotlinx.serialization.Serializable


@Serializable
data class RoleDTO(var username: String, var isAdmin: Boolean)