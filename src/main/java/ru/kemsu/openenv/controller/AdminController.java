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
import ru.kemsu.openenv.model.Organisation;
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

    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity<?> createOrganisation(@RequestBody final OrganisationDTO dto) {
        Organisation org = converterFacade.convert(dto);
        Organisation ret = service.create(org);
        return new ResponseEntity<>(ret, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteOrganisation(@RequestBody final OrganisationDTO dto) {
        Organisation org = converterFacade.convert(dto);
        Organisation temp = service.findByName(org.getName());
        service.delete(temp.getId());
        return new ResponseEntity<>("yep", HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> changeOrganisation(@RequestBody final OrganisationDTO dto) {
        Organisation org = converterFacade.convert(dto);
        Organisation tempid = service.findByName(org.getName());
        //String id = org.getId();
        Organisation ret = service.update(tempid.getId(), org);
        return new ResponseEntity<>(ret, HttpStatus.OK);
    }

}
