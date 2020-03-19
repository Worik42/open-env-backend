package ru.kemsu.openenv.controller

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController
import ru.kemsu.openenv.converter.ConverterFacade
import ru.kemsu.openenv.dto.MessageDTO
import ru.kemsu.openenv.dto.OrganisationDTO
import ru.kemsu.openenv.model.GeoCoord
import ru.kemsu.openenv.service.GeoCoordService
import ru.kemsu.openenv.service.OrganisationService

@RestController
@RequestMapping("/api/v1/admin")
class AdminController @Autowired constructor(private val service: OrganisationService, private val geoservice: GeoCoordService, private val converterFacade: ConverterFacade) {

    @RequestMapping(method = [RequestMethod.PUT])
    fun createOrganisation(@RequestBody dto: OrganisationDTO?): ResponseEntity<*> {
        val org = converterFacade.convert(dto)
        service.create(org)
        val id = service.findByName(org.name).id
        val geo = GeoCoord()
        geo.id = id
        geo.coordinate = org.position
        geoservice.create(geo)
        return ResponseEntity(geo, HttpStatus.OK)
    }

    @RequestMapping(method = [RequestMethod.DELETE])
    fun deleteOrganisation(@RequestBody dto: OrganisationDTO?): ResponseEntity<*> {
        val org = converterFacade.convert(dto)
        val temp = service.findByName(org.name)
        service.delete(temp.id)
        return ResponseEntity(MessageDTO("Success"), HttpStatus.OK)
    }

    @RequestMapping(method = [RequestMethod.POST])
    fun changeOrganisation(@RequestBody dto: OrganisationDTO?): ResponseEntity<*> {
        val org = converterFacade.convert(dto)
        val tempid = service.findByName(org.name)
        val ret = service.update(tempid.id, org)
        return ResponseEntity(ret, HttpStatus.OK)
    }

}
