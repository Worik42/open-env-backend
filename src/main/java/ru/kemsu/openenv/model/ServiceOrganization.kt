package ru.kemsu.openenv.model

import java.io.Serializable

data class ServiceOrganization(
        private var name: String,
        private var price: Int,
        private var description: String,
        private var location: Position,
        private var timeStart: Int,
        private var timeEnd: Int,
        private var isWorkWeekend: Boolean
) : BaseEntity(), Serializable