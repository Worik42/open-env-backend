package ru.kemsu.openenv.repository

import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.data.mongodb.repository.Query
import org.springframework.stereotype.Repository
import ru.kemsu.openenv.model.Claim

@Repository
interface ClaimsRepository : MongoRepository<Claim, String> {
    @Query(value = "{ serviceID : ?0}", fields = "{ serviceID : 0 }")
    fun findByIdService(idService: String): List<Claim>
}