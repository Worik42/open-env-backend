package ru.kemsu.openenv.controller

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import ru.kemsu.openenv.dto.ClaimDTO
import ru.kemsu.openenv.dto.MessageDTO

@RestController
class ClaimController {
    @RequestMapping(value = ["/api/claim"], method = [RequestMethod.POST])
    fun createClaim(@RequestBody claim: ClaimDTO): ResponseEntity<*> {
        return ResponseEntity(MessageDTO("OK"), HttpStatus.OK)
    }

    @RequestMapping(value = ["/api/claim/confirm/{user_id}"], method = [RequestMethod.GET])
    fun createClaim(@PathVariable user_id: String): ResponseEntity<*> {
        return ResponseEntity(MessageDTO("OK"), HttpStatus.OK)
    }


}