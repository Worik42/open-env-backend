package ru.kemsu.openenv.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ru.kemsu.openenv.converter.ConverterFacade;
import ru.kemsu.openenv.dto.MessageDTO;
import ru.kemsu.openenv.dto.OrganisationDTO;
import ru.kemsu.openenv.model.GeoCoord;
import ru.kemsu.openenv.model.Organisation;
import ru.kemsu.openenv.service.GeoCoordService;
import ru.kemsu.openenv.service.OrganisationService;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/api/admin")
public class AdminController {
    private final OrganisationService service;
    private final GeoCoordService geoservice;
    private final ConverterFacade converterFacade;

    @Autowired
    public AdminController(OrganisationService service, GeoCoordService geoservice, ConverterFacade converterFacade) {
        this.service = service;
        this.converterFacade = converterFacade;
        this.geoservice = geoservice;
    }

    @RequestMapping(method = RequestMethod.OPTIONS)
    public void corsHeaders(HttpServletResponse response) {
        response.addHeader("Access-Control-Allow-Origin", "*");
        response.addHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS");
        response.addHeader("Access-Control-Allow-Headers", "origin, content-type, accept, x-requested-with");
        response.addHeader("Access-Control-Max-Age", "3600");
    }

    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity<?> createOrganisation(@RequestBody final OrganisationDTO dto) {
        Organisation org = converterFacade.convert(dto);
        service.create(org);
        String id = service.findByName(org.getName()).getId();
        GeoCoord geo = new GeoCoord();
        geo.setId(id);
        geo.setCoordinate(org.getPosition());
        geoservice.create(geo);
        return new ResponseEntity<>(geo, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteOrganisation(@RequestBody final OrganisationDTO dto) {
        Organisation org = converterFacade.convert(dto);
        Organisation temp = service.findByName(org.getName());
        service.delete(temp.getId());
        return new ResponseEntity<>(new MessageDTO("Success"), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> changeOrganisation(@RequestBody final OrganisationDTO dto) {
        Organisation org = converterFacade.convert(dto);
        Organisation tempid = service.findByName(org.getName());
        Organisation ret = service.update(tempid.getId(), org);
        return new ResponseEntity<>(ret, HttpStatus.OK);
    }

}
