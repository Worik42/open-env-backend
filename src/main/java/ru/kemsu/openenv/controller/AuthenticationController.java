package ru.kemsu.openenv.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ru.kemsu.openenv.dto.LoginDTO;
import ru.kemsu.openenv.dto.MessageDTO;
import ru.kemsu.openenv.dto.RoleDTO;
import ru.kemsu.openenv.dto.TokenDTO;
import ru.kemsu.openenv.model.User;
import ru.kemsu.openenv.security.service.TokenService;
import ru.kemsu.openenv.service.UserService;


@RestController
public class AuthenticationController {

    private final Logger log = LoggerFactory.getLogger(this.getClass());


    private final TokenService tokenService;

    private final UserService service;

    @Autowired
    public AuthenticationController(final TokenService tokenService, UserService service) {
        this.tokenService = tokenService;
        this.service = service;
    }

    @RequestMapping(value = "/api/auth", method = RequestMethod.POST)
    public ResponseEntity<?> authenticate(@RequestBody final LoginDTO dto) {
        final String token = tokenService.getToken(dto.getUsername(), dto.getPassword());

        if (token != null) {
            final TokenDTO response = new TokenDTO();
            response.setToken(token);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Authentication failed", HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value = "/api/user/changeRole", method = RequestMethod.POST)
    public ResponseEntity<?> changeRole(@RequestBody final RoleDTO dto) {
        User user = service.changeRole(dto.getUsername(), dto.getIsAdmin() != 0);
        if (user != null)
            return new ResponseEntity<>(dto, HttpStatus.OK);
        else
            return new ResponseEntity<>(new MessageDTO("User not found"), HttpStatus.BAD_REQUEST);
    }

}
