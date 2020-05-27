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

@RestController
@RequestMapping("/api/organizations")
class OrganizationController @Autowired constructor(private val service: OrganizationService) {

    @RequestMapping(method = [RequestMethod.PUT])
    fun createOrganization(@RequestBody dto: OrganizationDTO): ResponseEntity<*> {
        val org = Organization(dto.name, dto.typeServices, dto.description, dto.address, dto.phone, dto.site, dto.timeStart, dto.timeEnd, dto.isWorkWeekend)
        service.create(org)
        return ResponseEntity(org, HttpStatus.OK)
    }

    @RequestMapping(value = ["/{org_id}"], method = [RequestMethod.DELETE])
    fun deleteOrganisation(@PathVariable org_id: String): ResponseEntity<*> {
        val temp = service.find(org_id)
        service.delete(temp.id)
        return ResponseEntity(MessageDTO("Success"), HttpStatus.OK)
    }

    @RequestMapping(method = [RequestMethod.POST])
    fun changeOrganisation(@RequestBody dto: OrganizationChangeDTO): ResponseEntity<*> {
        val ret = service.update(dto)
        return ResponseEntity(ret, HttpStatus.OK)
    }

    @RequestMapping(method = [RequestMethod.GET])
    fun getOrganization(): ResponseEntity<List<Organization>> {
        return ResponseEntity(service.findAll(), HttpStatus.OK)
    }

}
