package ru.kemsu.openenv.dto

import kotlinx.serialization.Serializable

@Serializable
data class Services(
        val name: String,
        val description: String,
        val price: Int,
        val timeStart: Int,
        val timeEnd: Int,
        val isWorkWeekend: Boolean
)