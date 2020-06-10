package ru.kemsu.openenv.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import ru.kemsu.openenv.model.User;


@Repository
public interface UserRepository extends MongoRepository<User, String> {

    User findByUsername(final String userName);

}
/**
 * @startuml interface UserRepository {
 * fun findByUsername(userName: String): User
 * }
 * @enduml
 */