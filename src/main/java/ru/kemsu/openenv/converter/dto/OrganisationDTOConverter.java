package ru.kemsu.openenv.converter.dto;

import org.springframework.core.convert.converter.Converter;
import ru.kemsu.openenv.dto.CoordinateDTO;
import ru.kemsu.openenv.dto.OrganisationDTO;
import ru.kemsu.openenv.model.Coordinate;
import ru.kemsu.openenv.model.Organisation;

import java.util.ArrayList;


public class OrganisationDTOConverter implements Converter<OrganisationDTO, Organisation> {

    @Override
    public Organisation convert(final OrganisationDTO dto) {
        final Organisation organisation = new Organisation();

        organisation.setName(dto.getName());

        ArrayList<Coordinate> coo = new ArrayList<>();

        for (CoordinateDTO coodr : dto.getPosition()
        ) {
            Coordinate coordinate = new Coordinate();
            coordinate.setLatitude(coodr.getLatitude());
            coordinate.setLongitude(coodr.getLongitude());
            coo.add(coordinate);
        }

        organisation.setPosition(coo);
        organisation.setDescriptions(dto.getDescriptions());

        return organisation;
    }
}
