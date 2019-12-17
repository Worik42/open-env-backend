package ru.kemsu.openenv.converter.dto;

import org.springframework.core.convert.converter.Converter;
import ru.kemsu.openenv.dto.MapDTO;
import ru.kemsu.openenv.model.GeoCoord;

public class MapDTOConverter implements Converter<MapDTO, GeoCoord> {

    @Override
    public GeoCoord convert(final MapDTO dto) {
        final GeoCoord geocoord = new GeoCoord();

        geocoord.setCoordinate(dto.getCoordinate());

        geocoord.getCoordinate();

        return geocoord;
    }
}
