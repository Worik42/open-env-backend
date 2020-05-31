package ru.kemsu.openenv.model

import java.io.Serializable
import java.util.*

data class Claim(
        var userIDs: List<UserClaim>,
        var serviceID: String,
        var date: Date
) : BaseEntity(), Serializable