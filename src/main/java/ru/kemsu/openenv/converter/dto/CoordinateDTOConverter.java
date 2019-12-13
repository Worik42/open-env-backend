package ru.kemsu.openenv.converter.dto;

import org.springframework.core.convert.converter.Converter;
import ru.kemsu.openenv.dto.CoordinateDTO;
import ru.kemsu.openenv.model.Coordinate;


public class CoordinateDTOConverter implements Converter<CoordinateDTO, Coordinate> {

    @Override
    public Coordinate convert(final CoordinateDTO dto) {
        final Coordinate coord = new Coordinate();

        coord.setLatitude(dto.getLatitude());
        coord.setLongitude(dto.getLongitude());

        return coord;
    }
}
