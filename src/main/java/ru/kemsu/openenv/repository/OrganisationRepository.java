package ru.kemsu.openenv.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import ru.kemsu.openenv.model.Organisation;

@Repository
public interface OrganisationRepository extends MongoRepository<Organisation, String> {

    Organisation findByName(final String organisationName);

}
