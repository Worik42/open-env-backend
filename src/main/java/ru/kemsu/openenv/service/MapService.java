package ru.kemsu.openenv.service;

import ru.kemsu.openenv.model.Organisation;

import java.util.List;

public interface MapService {

    Organisation find(String id);

    Organisation findByName(String organisationName);

    List<Organisation> findAll();

}
