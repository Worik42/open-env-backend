package ru.kemsu.openenv.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import ru.kemsu.openenv.model.Organisation;

public interface OrganisationRepository extends MongoRepository<Organisation, String> {

    Organisation findByOrganisationname(final String organisationName);

}
