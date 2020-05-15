package ru.kemsu.openenv.service

import ru.kemsu.openenv.model.Support

interface ISupportService {
    fun createSupport(support: Support): Support
}