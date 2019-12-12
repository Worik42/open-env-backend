package ru.kemsu.openenv.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kemsu.openenv.model.Organisation;
import ru.kemsu.openenv.repository.OrganisationRepository;

import java.util.List;

@Service
public class BasicMapService implements MapService {

    private final OrganisationRepository repository;

    @Autowired
    public BasicMapService(final OrganisationRepository repository) {
        this.repository = repository;
    }

    @Override
    public Organisation find(final String id) {
        return repository.findOne(id);
    }

    @Override
    public Organisation findByName(final String organisationName) {
        return repository.findByName(organisationName);
    }

    @Override
    public List<Organisation> findAll() {
        return repository.findAll();
    }

}
