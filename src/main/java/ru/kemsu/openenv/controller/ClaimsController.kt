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
import ru.kemsu.openenv.dto.ClaimDTO
import ru.kemsu.openenv.dto.MessageDTO
import ru.kemsu.openenv.dto.UserStatusDTO
import ru.kemsu.openenv.service.ClaimsService
import ru.kemsu.openenv.service.UserService

@RestController
class ClaimsController @Autowired constructor(private val service: ClaimsService, private val serviceUser: UserService) {
    @RequestMapping(value = ["/api/claim"], method = [RequestMethod.POST])
    fun createClaimOrSubscribe(@RequestBody claim: ClaimDTO): ResponseEntity<*> {
        val authentication: Authentication = SecurityContextHolder.getContext().authentication
        val currentPrincipalName: String = authentication.name
        val user = serviceUser.findByUsername(currentPrincipalName)
        service.createClaimOrAddUserToClaim(claim, user.id)
        return ResponseEntity(MessageDTO("OK"), HttpStatus.OK)
    }

    @RequestMapping(value = ["/api/claim/confirm"], method = [RequestMethod.GET])
    fun createClaim(@RequestBody status: UserStatusDTO): ResponseEntity<*> {
        service.updateUserStatus(status)
        return ResponseEntity(MessageDTO("OK"), HttpStatus.OK)
    }

}