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
    @RequestMapping(method = [RequestMethod.PUT])
    fun createService(@RequestBody dto: ServicesDTO): ResponseEntity<*> {
        val serv = service.create(dto)
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

    @RequestMapping(method = [RequestMethod.GET])
    fun getServices(): ResponseEntity<*> {
        return ResponseEntity(serviceOrganization.findAll(), HttpStatus.OK)
    }

    @RequestMapping(value = ["/{id_organization}"], method = [RequestMethod.GET])
    fun getServicesByIdOrganization(@PathVariable id_organization: String): ResponseEntity<*> {
        return ResponseEntity(service.findByIdOrganization(id_organization), HttpStatus.OK)
    }

    /**
     * todo:// Сделать методы , поидее надо сделать метод услуги на короторую записался пользователь
     * /api/services/subscribe - Метод записи на услугу
     * /api/services/claims - Метод изменения статуса заявки пользователя
     */
    @RequestMapping(value = ["/{id_service}"], method = [RequestMethod.GET])
    fun subscribe(@PathVariable id_service: String): ResponseEntity<*> {
        return ResponseEntity(service.findByIdOrganization(id_service), HttpStatus.OK)
    }
}