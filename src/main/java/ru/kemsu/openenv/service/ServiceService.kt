package ru.kemsu.openenv.service

import ru.kemsu.openenv.dto.ServicesChangeDTO
import ru.kemsu.openenv.dto.ServicesDTO
import ru.kemsu.openenv.model.Service

interface ServiceService {
    fun create(dto: ServicesDTO, id: String): Service

    fun find(id: String): Service

    fun findAll(): List<Service>

    fun update(service: ServicesChangeDTO): Service

    fun delete(id: String): Boolean
}