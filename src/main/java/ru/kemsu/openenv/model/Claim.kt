package ru.kemsu.openenv.model

import java.io.Serializable
import java.util.*

data class Claim(
        var userID: String,
        var serviceID: String,
        var date: Date,
        var status: Int,
        var description: String
) : BaseEntity(), Serializable