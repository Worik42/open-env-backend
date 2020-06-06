package ru.kemsu.openenv.controller

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController
import ru.kemsu.openenv.dto.TypeServiceDTO
import ru.kemsu.openenv.model.TypeServices
import ru.kemsu.openenv.service.TypeServicesService


@RestController
@RequestMapping("/api/typeServices")
class TypeServicesController @Autowired constructor(private val service: TypeServicesService) {

    @RequestMapping(method = [RequestMethod.GET])
    fun getAllTypes(): ResponseEntity<*> {
        return ResponseEntity(service.findAll(), HttpStatus.OK)
    }

    @RequestMapping(method = [RequestMethod.POST])
    fun createType(@RequestBody dto: TypeServiceDTO): ResponseEntity<*> {
        val ser = TypeServices(dto.name)
        return ResponseEntity(service.create(ser), HttpStatus.OK)
    }
}