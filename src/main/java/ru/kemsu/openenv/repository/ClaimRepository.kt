package ru.kemsu.openenv.repository

import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository
import ru.kemsu.openenv.model.Claim

@Repository
interface ClaimRepository : MongoRepository<Claim, String> {

    fun findByUserID(userID: String): List<Claim>

    fun findByServiceID(serviceID: String): List<Claim>

}