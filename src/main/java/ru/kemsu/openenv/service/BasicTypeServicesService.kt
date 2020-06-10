package ru.kemsu.openenv.service

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import ru.kemsu.openenv.model.TypeServices
import ru.kemsu.openenv.repository.TypeServicesRepository
/**
 * @startuml
 * class BasicTypeServicesService implements TypeServicesService{
 *  - val repository: TypeServicesRepository
 *   fun getTypeById(idType: String): TypeServices
 * fun  findAll(): List<TypeServices>
 *   fun create(type: TypeServices)
 * }
 * @enduml
 */
@Service
class BasicTypeServicesService @Autowired constructor(private val repository: TypeServicesRepository) : TypeServicesService {
    override fun getTypeById(idType: String): TypeServices {
        return repository.findById(idType).get()
    }

    override fun findAll(): List<TypeServices> {
        return repository.findAll()
    }

    override fun create(type: TypeServices) {
        repository.save(type)
    }
}