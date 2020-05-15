package ru.kemsu.openenv.controller

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.security.core.Authentication
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController
import ru.kemsu.openenv.dto.MessageDTO
import ru.kemsu.openenv.dto.SupportDTO
import ru.kemsu.openenv.model.Support
import ru.kemsu.openenv.service.ISupportService

@RestController
@RequestMapping("/api/report")
class SupportController @Autowired constructor(private val service: ISupportService) {

    @RequestMapping(method = [RequestMethod.POST])
    fun report(@RequestBody supp: SupportDTO): ResponseEntity<*> {
        val authentication: Authentication = SecurityContextHolder.getContext().authentication
        val currentPrincipalName: String = authentication.name
        val support = Support(currentPrincipalName, supp.title, supp.text)
        service.createSupport(support)
        return ResponseEntity(MessageDTO("Success"), HttpStatus.OK)
    }

}