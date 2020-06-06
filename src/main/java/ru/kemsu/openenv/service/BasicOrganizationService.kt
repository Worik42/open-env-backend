package ru.kemsu.openenv.service

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import ru.kemsu.openenv.dto.OrganizationChangeDTO
import ru.kemsu.openenv.model.Organization
import ru.kemsu.openenv.repository.OrganisationRepository
import java.time.LocalDateTime

@Service
class BasicOrganizationService @Autowired constructor(private val repository: OrganisationRepository) : OrganizationService {
    override fun create(organisation: Organization): Organization {
        organisation.createdAt = LocalDateTime.now().toString()
        return repository.save(organisation)
    }

    override fun find(id: String): Organization {
        return repository.findById(id).get()
    }

    override fun findByName(organisationName: String): Organization {
        return repository.findByName(organisationName)
    }

    override fun findAll(): List<Organization> {
        return repository.findAll()
    }

    override fun findByIdType(idType: String): MutableList<Organization> {
        return repository.findByIdTypeServices(idType)
    }

    override fun update(organization: OrganizationChangeDTO): Organization {
        val saved = repository.findById(organization.id).get()
        if (saved != null) {
            saved.updatedAt = LocalDateTime.now().toString()
        }
        repository.save(saved)
        return saved
    }

    override fun delete(id: String): String {
        repository.deleteById(id)
        return id
    }

}
