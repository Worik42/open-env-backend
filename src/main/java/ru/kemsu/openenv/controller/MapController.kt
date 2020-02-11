package ru.kemsu.openenv.controller

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController
import ru.kemsu.openenv.converter.ConverterFacade
import ru.kemsu.openenv.service.MapService

@RestController
@RequestMapping(value = ["/api/map"])
class MapController @Autowired constructor(private val service: MapService,
                                           private val converterFacade: ConverterFacade) {
    @get:RequestMapping(method = [RequestMethod.GET])
    val allOrganisation: ResponseEntity<*>
        get() {
            val listOrg = service.findAll()
            return ResponseEntity(listOrg, HttpStatus.OK)
        }

}
