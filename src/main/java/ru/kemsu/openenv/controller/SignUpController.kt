package ru.kemsu.openenv.controller

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController
import ru.kemsu.openenv.converter.ConverterFacade
import ru.kemsu.openenv.dto.UserDTO
import ru.kemsu.openenv.service.UserService

@RestController
@RequestMapping("/api/v1/signup")
class SignUpController @Autowired constructor(private val service: UserService,
                                              private val converterFacade: ConverterFacade) {
    @RequestMapping(method = [RequestMethod.POST])
    fun signUp(@RequestBody dto: UserDTO?): ResponseEntity<*> {
        return ResponseEntity(service.create(converterFacade.convert(dto)), HttpStatus.OK)
    }

}
