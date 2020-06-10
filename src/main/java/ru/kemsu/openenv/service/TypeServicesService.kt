package ru.kemsu.openenv.service

import ru.kemsu.openenv.model.TypeServices

/**
 * @startuml
 * interface TypeServicesService {
 * fun getTypeById(idType: String): TypeServicesfun find(id: String): ServiceOrganization
 * fun findAll(): List<TypeServices>
 *    fun create(type: TypeServices)
 * }
 * @enduml
 */

interface TypeServicesService {
    fun getTypeById(idType: String): TypeServices

    fun findAll(): List<TypeServices>

    fun create(type: TypeServices)
}