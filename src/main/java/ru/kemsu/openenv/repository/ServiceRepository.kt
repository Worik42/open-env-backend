package ru.kemsu.openenv.repository

import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.data.mongodb.repository.Query
import org.springframework.stereotype.Repository
import ru.kemsu.openenv.model.ServiceOrganization

@Repository
interface ServiceRepository : MongoRepository<ServiceOrganization, String> {

    @Query(value = "{ idOrganization : ?0}", fields = "{ idOrganization : 0 }")
    fun findByIdOrganization(idOrganization: String): List<ServiceOrganization>
}