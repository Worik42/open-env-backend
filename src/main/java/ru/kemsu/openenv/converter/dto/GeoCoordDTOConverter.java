package ru.kemsu.openenv.converter.dto;

import org.springframework.core.convert.converter.Converter;
import ru.kemsu.openenv.dto.GeoCoordDTO;
import ru.kemsu.openenv.model.GeoCoord;


public class GeoCoordDTOConverter implements Converter<GeoCoordDTO, GeoCoord> {

    @Override
    public GeoCoord convert(final GeoCoordDTO dto) {
        final GeoCoord geoCoord = new GeoCoord();

        geoCoord.setCoordinate(dto.getCoordinate());
        geoCoord.getCoordinate();

        return geoCoord;
    }
}
