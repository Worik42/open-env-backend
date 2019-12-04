package ru.kemsu.openenv.converter.dto;

import org.springframework.core.convert.converter.Converter;
import ru.kemsu.openenv.dto.MapDTO;
import ru.kemsu.openenv.model.Organisation;

public class MapDTOConverter implements Converter<MapDTO, Organisation> {

    @Override
    public Organisation convert(final MapDTO dto) {
        final Organisation organisation = new Organisation();

        organisation.setName(dto.getName());
        organisation.setPosition(dto.getPosition());
        organisation.setDescriptions(dto.getDescriptions());

        organisation.getName();
        organisation.getPosition();
        organisation.getDescriptions();

        return organisation;
    }
}
