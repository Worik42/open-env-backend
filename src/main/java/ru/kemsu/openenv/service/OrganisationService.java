package ru.kemsu.openenv.service;

import ru.kemsu.openenv.model.Organisation;

import java.util.List;

public interface OrganisationService {

    Organisation create(Organisation object);

    Organisation find(String id);

    Organisation findByOrganisationname(String organisationName);

    List<Organisation> findAll();

    Organisation update(String id, Organisation object);

    String delete(String id);
}
