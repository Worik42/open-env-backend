package ru.kemsu.openenv.controller

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController
import ru.kemsu.openenv.dto.MessageDTO

@RestController
@RequestMapping("/api/about")
class AppAboutController {

    @RequestMapping(method = [RequestMethod.GET])
    fun getInformation(): ResponseEntity<*> {
        return ResponseEntity(MessageDTO("The best application"), HttpStatus.OK)
    }

}
