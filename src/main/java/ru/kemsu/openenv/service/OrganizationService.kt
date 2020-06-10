package ru.kemsu.openenv.service

import ru.kemsu.openenv.dto.OrganizationChangeDTO
import ru.kemsu.openenv.model.Organization

/**
 * @startuml
 * interface OrganizationService {
 * fun create(org: Organization): Organization
 * fun find(id: String): Organization
 * fun findByName(organisationName: String): Organization
 * fun findAll(): List<Organization>
 *     fun update(organization: OrganizationChangeDTO): Organization
 *     fun delete(id: String): String
 *     fun findByIdType(idType: String): List<Organization>
 * }
 * @enduml
 */
interface OrganizationService {
    fun create(org: Organization): Organization
    fun find(id: String): Organization
    fun findByName(organisationName: String): Organization
    fun findAll(): List<Organization>
    fun update(organization: OrganizationChangeDTO): Organization
    fun delete(id: String): String
    fun findByIdType(idType: String): List<Organization>
}