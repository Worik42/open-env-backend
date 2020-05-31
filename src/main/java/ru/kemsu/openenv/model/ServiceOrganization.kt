package ru.kemsu.openenv.model

import java.io.Serializable

data class ServiceOrganization(
        var idOrganization: String,
        var name: String,
        var price: Int,
        var description: String,
        var location: Position,
        var timeStart: Int,
        var timeEnd: Int,
        var isWorkWeekend: Boolean
) : BaseEntity(), Serializable