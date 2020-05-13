package ru.kemsu.openenv.controller

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.security.core.Authentication
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController
import ru.kemsu.openenv.dto.ResetDTO


@RestController
class UserController {
    @RequestMapping(value = ["/api/user/reset"], method = [RequestMethod.POST])
    fun resetPwd(@RequestBody dto: ResetDTO): ResponseEntity<*> {
        val authentication: Authentication = SecurityContextHolder.getContext().authentication
        val currentPrincipalName: String = authentication.name
        return ResponseEntity(currentPrincipalName, HttpStatus.OK)
//        val user = service.changeRole(dto.username, dto.isAdmin != 0)
//        return if (user != null) ResponseEntity(dto, HttpStatus.OK) else ResponseEntity(MessageDTO("User not found"), HttpStatus.BAD_REQUEST)
    }

}