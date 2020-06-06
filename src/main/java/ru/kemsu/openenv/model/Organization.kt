package ru.kemsu.openenv.model

import java.io.Serializable

data class Organization(
        var name: String,
        var idTypeServices: String,
        var description: String,
        var address: String,
        var phone: String,
        var site: String,
        var timeStart: Int,
        var timeEnd: Int,
        var isWorkWeekend: Boolean
) : BaseEntity(), Serializable