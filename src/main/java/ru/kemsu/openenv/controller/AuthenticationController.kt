package ru.kemsu.openenv.controller

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController
import ru.kemsu.openenv.dto.MessageDTO
import ru.kemsu.openenv.dto.RoleDTO
import ru.kemsu.openenv.service.UserService


@RestController
class AuthenticationController @Autowired constructor(
        private val service: UserService) {

    @RequestMapping(value = ["/api/user/changeRole"], method = [RequestMethod.POST])
    fun changeRole(@RequestBody dto: RoleDTO): ResponseEntity<*> {
        val user = service.changeRole(dto.username, dto.isAdmin != 0)
        return if (user != null) ResponseEntity(dto, HttpStatus.OK) else ResponseEntity(MessageDTO("User not found"), HttpStatus.BAD_REQUEST)
    }

}
