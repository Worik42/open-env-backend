package ru.kemsu.openenv.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.kemsu.openenv.converter.ConverterFacade;
import ru.kemsu.openenv.service.MapService;

@RestController
@RequestMapping("/api/map")
public class MapController {

    private final MapService service;
    private final ConverterFacade converterFacade;

    // Here is an error
    @Autowired
    public MapController(final MapService service, final ConverterFacade converterFacade) {
        this.service = service;
        this.converterFacade = converterFacade;
    }

/*

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> getOrganisation() {
        return new ResponseEntity<>( service.findAll(), HttpStatus.OK);
    }
*/
}
