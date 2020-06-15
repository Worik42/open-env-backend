package ru.kemsu.openenv.controller

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.security.core.Authentication
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.web.bind.annotation.*
import ru.kemsu.openenv.dto.ClaimDTO
import ru.kemsu.openenv.dto.MessageDTO
import ru.kemsu.openenv.service.ClaimService
import ru.kemsu.openenv.service.UserService

/**
 * дописать контроллер для записи
 */
@RestController
class ClaimController @Autowired constructor(private val service: ClaimService, private val userService: UserService) {
    @RequestMapping(value = ["/api/claims"], method = [RequestMethod.POST])
    fun createOrSubscibeClaim(@RequestBody claim: ClaimDTO): ResponseEntity<*> {
        val authentication: Authentication = SecurityContextHolder.getContext().authentication
        val currentPrincipalName: String = authentication.name
        val user = userService.findByUsername(currentPrincipalName)
        service.createClaim(claim, user.id)
        return ResponseEntity(MessageDTO("OK"), HttpStatus.OK)
    }

    @RequestMapping(value = ["/api/claims/confirm/{id_claim}"], method = [RequestMethod.GET])
    fun confirm(@PathVariable id_claim: String): ResponseEntity<*> {
        service.changeStatusClaim(1, id_claim)
        return ResponseEntity(MessageDTO("OK"), HttpStatus.OK)
    }

    @RequestMapping(value = ["/api/claims/{id_service}"], method = [RequestMethod.GET])
    fun getClaimsByIdService(@PathVariable id_service: String): ResponseEntity<*> {
        return ResponseEntity(service.getClaimsByIdService(id_service), HttpStatus.OK)
    }

    @RequestMapping(value = ["/api/claims/{id_user}"], method = [RequestMethod.GET])
    fun getClaimsByIdUser(@PathVariable id_user: String): ResponseEntity<*> {
        return ResponseEntity(service.getClaimsByIdUser(id_user), HttpStatus.OK)
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
