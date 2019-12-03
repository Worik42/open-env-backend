package ru.kemsu.openenv.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ru.kemsu.openenv.converter.ConverterFacade;
import ru.kemsu.openenv.dto.OrganisationDTO;
import ru.kemsu.openenv.service.OrganisationService;

@RestController
@RequestMapping("/api/admin")

public class AdminController {

    private final OrganisationService service;

    private final ConverterFacade converterFacade;

    @Autowired
    public AdminController(final OrganisationService service,
                           final ConverterFacade converterFacade) {
        this.service = service;
        this.converterFacade = converterFacade;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> signUp(@RequestBody final OrganisationDTO dto) {
        return new ResponseEntity<>(service.create(converterFacade.convert(dto)), HttpStatus.OK);
    }

}
