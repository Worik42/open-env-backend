package ru.kemsu.openenv.controller

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.mail.SimpleMailMessage
import org.springframework.mail.javamail.JavaMailSender
import org.springframework.security.core.Authentication
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController
import ru.kemsu.openenv.dto.MessageDTO
import ru.kemsu.openenv.dto.UserChangeDTO
import ru.kemsu.openenv.service.UserService


@RestController
class UserController @Autowired constructor(private val service: UserService, private val emailSender: JavaMailSender) {
    /**
     * Берем юзера из токена, делаем метод в сервисе с рандомной генерацией пароля и возврат этого пароля.
     * отправка пароля на мыло
     */
    @RequestMapping(value = ["/api/user/reset"], method = [RequestMethod.POST])
    fun resetPwd(): ResponseEntity<*> {
        val authentication: Authentication = SecurityContextHolder.getContext().authentication
        val currentPrincipalName: String = authentication.name
        val user = service.findByUsername(currentPrincipalName)
        val pass = service.resetPassword(currentPrincipalName)
        return if (pass != null) {
            val message = SimpleMailMessage()
            message.setTo(user.email)
            message.setSubject("OpenEnv - NEW password")
            message.setText(pass)
            emailSender.send(message)

            ResponseEntity(MessageDTO("OK"), HttpStatus.OK)
        } else {
            ResponseEntity(MessageDTO("OK"), HttpStatus.BAD_REQUEST)
        }
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
/**
 * @startuml
 * class TypeServicesController {
 *  - val service: UserService
 *  - val emailSender: JavaMailSender
 *  fun resetPwd(): ResponseEntity<*>
 *  fun getUserInformation(): ResponseEntity<*>
 *  fun updateUser(@RequestBody userChange: UserChangeDTO): ResponseEntity<*>
 * }
 * @enduml
 */