package ru.kemsu.openenv.service

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import ru.kemsu.openenv.model.Organisation
import ru.kemsu.openenv.repository.OrganisationRepository
import java.time.LocalDateTime

@Service
class BasicOrganisationService @Autowired constructor(private val repository: OrganisationRepository) : OrganisationService {
    override fun create(organisation: Organisation): Organisation {
        organisation.createdAt = LocalDateTime.now().toString()
        return repository.save(organisation)
    }

    override fun find(id: String): Organisation {
        return repository.findById(id).get()
    }

    override fun findByName(organisationName: String): Organisation {
        return repository.findByName(organisationName)
    }

    override fun findAll(): List<Organisation> {
        return repository.findAll()
    }

    override fun update(id: String, organisation: Organisation): Organisation {
        organisation.id = id
        val saved = repository.findById(id).get()
        if (saved != null) {
            organisation.createdAt = saved.createdAt
            organisation.updatedAt = LocalDateTime.now().toString()
        } else {
            organisation.createdAt = LocalDateTime.now().toString()
        }
        repository.save(organisation)
        return organisation
    }

    override fun delete(id: String): String {
        repository.deleteById(id)
        return id
    }

}
