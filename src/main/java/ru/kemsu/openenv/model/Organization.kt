package ru.kemsu.openenv.model

import java.io.Serializable

data class Organization(
        private var name: String,
        private var typeServices: String,
        private var description: String,
        private var address: String,
        private var phone: String,
        private var site: String,
        private var timeStart: Int,
        private var timeEnd: Int,
        private var isWorkWeekend: Boolean
) : BaseEntity(), Serializable