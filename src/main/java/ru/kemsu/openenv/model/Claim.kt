package ru.kemsu.openenv.model

import java.io.Serializable

data class Claim(
        private var userID: String,
        private var serviceID: String,
        private var date: String,
        private var status: Int
) : BaseEntity(), Serializable