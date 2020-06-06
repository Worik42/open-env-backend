package ru.kemsu.openenv.service

import ru.kemsu.openenv.model.TypeServices

interface TypeServicesService {
    fun getTypeById(idType: String): TypeServices

    fun findAll(): List<TypeServices>

    fun create(type: TypeServices)
}