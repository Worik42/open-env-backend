package ru.kemsu.openenv.service;

import ru.kemsu.openenv.dto.OrganizationChangeDTO;
import ru.kemsu.openenv.model.Organization;

import java.util.List;

public interface OrganizationService {

    Organization create(Organization object);

    Organization find(String id);

    Organization findByName(String organisationName);

    List<Organization> findAll();

    Organization update(OrganizationChangeDTO organization);

    String delete(String id);
}
