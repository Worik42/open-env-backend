package ru.kemsu.openenv.controller

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import ru.kemsu.openenv.dto.MessageDTO
import ru.kemsu.openenv.dto.OrganizationChangeDTO
import ru.kemsu.openenv.dto.OrganizationDTO
import ru.kemsu.openenv.model.Organization
import ru.kemsu.openenv.service.OrganizationService
import ru.kemsu.openenv.service.TypeServicesService

@RestController
@RequestMapping("/api/organizations")
class OrganizationController @Autowired constructor(private val service: OrganizationService, private val serviceType: TypeServicesService) {

    @RequestMapping(method = [RequestMethod.PUT])
    fun createOrganization(@RequestBody dto: OrganizationDTO): ResponseEntity<*> {
        val org = Organization(dto.name, dto.idTypeServices, dto.description, dto.address, dto.phone, dto.site, dto.timeStart, dto.timeEnd, dto.isWorkWeekend)
        service.create(org)
        return ResponseEntity(org, HttpStatus.OK)
    }

    @RequestMapping(value = ["/{org_id}"], method = [RequestMethod.DELETE])
    fun deleteOrganization(@PathVariable org_id: String): ResponseEntity<*> {
        val temp = service.find(org_id)
        service.delete(temp.id)
        return ResponseEntity(MessageDTO("Success"), HttpStatus.OK)
    }

    @RequestMapping(method = [RequestMethod.POST])
    fun changeOrganization(@RequestBody dto: OrganizationChangeDTO): ResponseEntity<*> {
        val ret = service.update(dto)
        return ResponseEntity(ret, HttpStatus.OK)
    }

    @RequestMapping(method = [RequestMethod.GET])
    fun getOrganizations(): ResponseEntity<List<Organization>> {
        return ResponseEntity(service.findAll(), HttpStatus.OK)
    }

    @RequestMapping(value = ["/{org_id}"], method = [RequestMethod.GET])
    fun getOrganization(@PathVariable org_id: String): ResponseEntity<*> {
        val temp = service.find(org_id)
        return ResponseEntity(temp, HttpStatus.OK)
    }

    @RequestMapping(value = ["/types/{id_type}"], method = [RequestMethod.GET])
    fun getOrganizationByIdType(@PathVariable id_type: String): ResponseEntity<*> {
        return ResponseEntity(service.findByIdType(id_type), HttpStatus.OK)
    }
}
/**
 * @startuml
 *
 * class OrganizationController {
 *  -val service: OrganizationService
 *    - val serviceType: TypeServicesService
 *  fun createOrganization(@RequestBody dto: OrganizationDTO): ResponseEntity<*>
 *  fun deleteOrganization(@PathVariable org_id: String): ResponseEntity<*>
 *  fun changeOrganization(@RequestBody dto: OrganizationChangeDTO): ResponseEntity<*>
 *  fun getOrganizations(): ResponseEntity<List<Organization>>
 *  fun getOrganization(@PathVariable org_id: String): ResponseEntity<*>
 *  fun getOrganizationByIdType(@PathVariable id_type: String): ResponseEntity<*>
 * }
 * @enduml
 */