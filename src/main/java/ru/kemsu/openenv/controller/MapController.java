package ru.kemsu.openenv.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ru.kemsu.openenv.converter.ConverterFacade;
import ru.kemsu.openenv.model.Organisation;
import ru.kemsu.openenv.service.MapService;

import java.util.List;

@RestController
@RequestMapping(value = "/api/map")
public class MapController {

    private final MapService service;
    private final ConverterFacade converterFacade;

    @Autowired
    public MapController(final MapService service,
                         final ConverterFacade converterFacade) {
        this.service = service;
        this.converterFacade = converterFacade;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> getAllOrganisation() {
        List<Organisation> listOrg = service.findAll();
        return new ResponseEntity<>(listOrg, HttpStatus.OK);
    }
}
