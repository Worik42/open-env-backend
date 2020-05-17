package ru.kemsu.openenv.controller

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import ru.kemsu.openenv.dto.MessageDTO
import ru.kemsu.openenv.dto.ServicesChangeDTO
import ru.kemsu.openenv.dto.ServicesDTO


@RestController
@RequestMapping("/api/services")
class ServiceController {
    @RequestMapping(value = ["/{id}"], method = [RequestMethod.PUT])
    fun createService(@RequestBody dto: ServicesDTO, @PathVariable id: String): ResponseEntity<*> {
        return ResponseEntity(MessageDTO("OK"), HttpStatus.OK)
    }

    @RequestMapping(method = [RequestMethod.POST])
    fun changeService(@RequestBody dto: ServicesChangeDTO): ResponseEntity<*> {
        return ResponseEntity(MessageDTO("OK"), HttpStatus.OK)
    }

    @RequestMapping(value = ["/{id}"], method = [RequestMethod.DELETE])
    fun deleteService(@PathVariable id: String): ResponseEntity<*> {
        return ResponseEntity(MessageDTO("OK"), HttpStatus.OK)
    }

    @RequestMapping(value = ["/{id_organization}"], method = [RequestMethod.GET])
    fun getServices(@PathVariable id_organization: String): ResponseEntity<*> {
        return ResponseEntity(MessageDTO("OK"), HttpStatus.OK)
    }


}