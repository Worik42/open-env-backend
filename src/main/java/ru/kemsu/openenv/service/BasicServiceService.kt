package ru.kemsu.openenv.service

import org.springframework.beans.factory.annotation.Autowired
import ru.kemsu.openenv.dto.ServicesChangeDTO
import ru.kemsu.openenv.dto.ServicesDTO
import ru.kemsu.openenv.model.Position
import ru.kemsu.openenv.model.Service
import ru.kemsu.openenv.repository.ServiceRepository

@Service
class BasicServiceService @Autowired constructor(private val repository: ServiceRepository) : ServiceService {
    override fun create(dto: ServicesDTO, id: String): Service {
        val position = Position(dto.location.latitude, dto.location.longitude)
        val service = Service(dto.name, dto.price, dto.description, position, dto.timeStart, dto.timeEnd, dto.isWorkWeekend)
        return repository.save(service)
    }

    override fun find(id: String): Service {
        return repository.findById(id).get()
    }

    override fun findAll(): List<Service> {
        return repository.findAll()
    }

    override fun update(service: ServicesChangeDTO): Service {
        val serv = repository.findById(service.)
    }


}