package ru.kemsu.openenv.controller

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import ru.kemsu.openenv.dto.ClaimDTO
import ru.kemsu.openenv.dto.MessageDTO

/**
 * дописать контроллер для записи
 */
@RestController
class ClaimController {
    @RequestMapping(value = ["/api/claim"], method = [RequestMethod.POST])
    fun createOrSubscibeClaim(@RequestBody claim: ClaimDTO): ResponseEntity<*> {
        return ResponseEntity(MessageDTO("OK"), HttpStatus.OK)
    }

    @RequestMapping(value = ["/api/claim/confirm/{user_id}"], method = [RequestMethod.GET])
    fun confirm(@PathVariable user_id: String): ResponseEntity<*> {
        return ResponseEntity(MessageDTO("OK"), HttpStatus.OK)
    }
}
/**
 * @startuml
 *
 * class ClaimController {
 *    - val service: ClaimService
 *    fun createOrSubscibeClaim( claim: ClaimDTO): ResponseEntity<*>
 *    fun confirm( user_id: String): ResponseEntity<*>
 * }
 * @enduml
 */
