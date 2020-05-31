package ru.kemsu.openenv.service

import ru.kemsu.openenv.dto.ServicesChangeDTO
import ru.kemsu.openenv.dto.ServicesDTO
import ru.kemsu.openenv.model.ServiceOrganization

interface ServiceService {
    fun create(dto: ServicesDTO): ServiceOrganization

    fun find(id: String): ServiceOrganization

    fun findAll(): List<ServiceOrganization>

    fun update(service: ServicesChangeDTO)

    fun delete(id: String): Boolean

    fun findByIdOrganization(id: String): List<ServiceOrganization>
}