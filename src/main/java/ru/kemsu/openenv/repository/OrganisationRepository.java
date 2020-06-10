package ru.kemsu.openenv.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import ru.kemsu.openenv.model.Organization;

import java.util.List;

@Repository
public interface OrganisationRepository extends MongoRepository<Organization, String> {

    Organization findByName(final String organisationName);

    List<Organization> findByIdTypeServices(final String idType);
}
/**
 * @startuml interface OrganisationRepository {
 * fun findByName(organisationName: String): Organization
 * fun findByIdTypeServices(idType: String): List<Organization>
 * }
 * @enduml
 */