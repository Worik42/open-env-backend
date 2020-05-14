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
import ru.kemsu.openenv.dto.ResetDTO
import ru.kemsu.openenv.dto.UserChangeDTO
import ru.kemsu.openenv.service.UserService


@RestController
class UserController @Autowired constructor(private val service: UserService) {

    @RequestMapping(value = ["/api/user/reset"], method = [RequestMethod.POST])
    fun resetPwd(@RequestBody dto: ResetDTO): ResponseEntity<*> {
        val authentication: Authentication = SecurityContextHolder.getContext().authentication
        val currentPrincipalName: String = authentication.name
        val result = service.changePassword(currentPrincipalName, dto.newPassword)
        return ResponseEntity(MessageDTO(result.toString()), HttpStatus.OK)
    }

    @RequestMapping(value = ["/api/user"], method = [RequestMethod.GET])
    fun getUserInformation(): ResponseEntity<*> {
        val authentication: Authentication = SecurityContextHolder.getContext().authentication
        val currentPrincipalName: String = authentication.name
        val result = service.findByUsername(currentPrincipalName)
        return ResponseEntity(result, HttpStatus.OK)
    }

    @RequestMapping(value = ["/api/user"], method = [RequestMethod.POST])
    fun updateUser(@RequestBody userChange: UserChangeDTO): ResponseEntity<*> {
        val authentication: Authentication = SecurityContextHolder.getContext().authentication
        val currentPrincipalName: String = authentication.name
        val result = service.updateUser(currentPrincipalName, userChange)
        return ResponseEntity(result, HttpStatus.OK)
    }


}