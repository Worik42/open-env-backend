package ru.kemsu.openenv.repository

import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository
import ru.kemsu.openenv.model.Support

@Repository
interface ISupportRepository : MongoRepository<Support, String> {

}
/**
 * @startuml
 * interface ISupportRepository {
 * }
 * @enduml
 */