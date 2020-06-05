package ru.kemsu.openenv.repository

import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository
import ru.kemsu.openenv.model.ServiceOrganization

@Repository
interface ServiceRepository : MongoRepository<ServiceOrganization, String> {

    fun findByIdOrganization(idOrganiztion: String): List<ServiceOrganization>

}