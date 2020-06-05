package ru.kemsu.openenv.service

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import ru.kemsu.openenv.dto.ServicesChangeDTO
import ru.kemsu.openenv.dto.ServicesDTO
import ru.kemsu.openenv.model.Position
import ru.kemsu.openenv.model.ServiceOrganization
import ru.kemsu.openenv.repository.ServiceRepository

@Service
class BasicServiceService @Autowired constructor(private val repository: ServiceRepository) : ServiceService {
    override fun create(dto: ServicesDTO, id: String): ServiceOrganization {
        val position = Position(dto.location.latitude, dto.location.longitude)
        val service = ServiceOrganization(id, dto.name, dto.price, dto.description, position, dto.timeStart, dto.timeEnd, dto.isWorkWeekend)
        return repository.save(service)
    }

    override fun find(id: String): ServiceOrganization {
        return repository.findById(id).get()
    }

    override fun findAll(): List<ServiceOrganization> {
        return repository.findAll()
    }

    override fun update(service: ServicesChangeDTO) {
        val serv = repository.findById(service.idService)
        if (serv != null) {

        }
    }

    override fun delete(id: String): Boolean {
        repository.deleteById(id)
        return true
    }

    override fun findByIdOrg(idOrg: String): List<ServiceOrganization> {
        return repository.findByIdOrganization(idOrg)
    }


}