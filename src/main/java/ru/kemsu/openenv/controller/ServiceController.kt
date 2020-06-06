package ru.kemsu.openenv.controller

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import ru.kemsu.openenv.dto.MessageDTO
import ru.kemsu.openenv.dto.ServicesChangeDTO
import ru.kemsu.openenv.dto.ServicesDTO
import ru.kemsu.openenv.service.OrganizationService
import ru.kemsu.openenv.service.ServiceService


@RestController
@RequestMapping("/api/services")
class ServiceController @Autowired constructor(private val service: ServiceService, private val serviceOrganization: OrganizationService) {
    @RequestMapping(value = ["/{id}"], method = [RequestMethod.PUT])
    fun createService(@RequestBody dto: ServicesDTO, @PathVariable id: String): ResponseEntity<*> {
        val serv = service.create(dto, id)
        return ResponseEntity(MessageDTO("OK"), HttpStatus.OK)
    }

    @RequestMapping(method = [RequestMethod.POST])
    fun changeService(@RequestBody dto: ServicesChangeDTO): ResponseEntity<*> {
        service.update(dto)
        return ResponseEntity(MessageDTO("OK"), HttpStatus.OK)
    }

    @RequestMapping(value = ["/{id}"], method = [RequestMethod.DELETE])
    fun deleteService(@PathVariable id: String): ResponseEntity<*> {
        service.delete(id)
        return ResponseEntity(MessageDTO("OK"), HttpStatus.OK)
    }

    @RequestMapping(value = ["/{id_organization}"], method = [RequestMethod.GET])
    fun getServices(@PathVariable id_organization: String): ResponseEntity<*> {
        return ResponseEntity(service.findByIdOrg(id_organization), HttpStatus.OK)
    }


    @RequestMapping(method = [RequestMethod.GET])
    fun getAllServices(): ResponseEntity<*> {
        return ResponseEntity(service.findAll(), HttpStatus.OK)
    }


}