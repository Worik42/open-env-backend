package ru.kemsu.openenv.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kemsu.openenv.model.Organisation;
import ru.kemsu.openenv.repository.OrganisationRepository;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class BasicOrganisationService implements OrganisationService {

    private final OrganisationRepository repository;

    @Autowired
    public BasicOrganisationService(final OrganisationRepository repository) {
        this.repository = repository;
    }



    @Override
    public Organisation create(final Organisation organisation) {
        organisation.setCreatedAt(String.valueOf(LocalDateTime.now()));
        return repository.save(organisation);
    }

    @Override
    public Organisation find(String id) {
        return repository.findById(id).get();
    }

    @Override
    public Organisation findByName(final String organisationName) {
        return repository.findByName(organisationName);
    }


    @Override
    public List<Organisation> findAll() {
        return repository.findAll();
    }

    @Override
    public Organisation update(final String id, final Organisation organisation) {
        organisation.setId(id);

        final Organisation saved = repository.findById(id).get();

        if (saved != null) {
            organisation.setCreatedAt(saved.getCreatedAt());
            organisation.setUpdatedAt(String.valueOf(LocalDateTime.now()));
        } else {
            organisation.setCreatedAt(String.valueOf(LocalDateTime.now()));
        }
        repository.save(organisation);
        return organisation;
    }

    @Override
    public String delete(final String id) {
        repository.deleteById(id);
        return id;
    }

}
