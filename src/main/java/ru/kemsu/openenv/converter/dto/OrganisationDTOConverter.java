package ru.kemsu.openenv.converter.dto;

import org.springframework.core.convert.converter.Converter;
import ru.kemsu.openenv.dto.OrganisationDTO;
import ru.kemsu.openenv.model.Organisation;


public class OrganisationDTOConverter implements Converter<OrganisationDTO, Organisation> {

    @Override
    public Organisation convert(final OrganisationDTO dto) {
        final Organisation organisation = new Organisation();

        organisation.setName(dto.setName());
        organisation.setPosition(dto.getPosition());
        organisation.setDescriptions(dto.getDescriptions());

        return organisation;
    }
}
