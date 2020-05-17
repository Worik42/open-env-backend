package ru.kemsu.openenv.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import ru.kemsu.openenv.model.Organization;

@Repository
public interface OrganisationRepository extends MongoRepository<Organization, String> {

    Organization findByName(final String organisationName);

}
