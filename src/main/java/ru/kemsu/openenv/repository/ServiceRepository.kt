package ru.kemsu.openenv.repository

import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository
import ru.kemsu.openenv.model.Service

@Repository
interface ServiceRepository : MongoRepository<Service, String> {
}