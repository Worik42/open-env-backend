package ru.kemsu.openenv.converter.dto;

import org.springframework.core.convert.converter.Converter;
import ru.kemsu.openenv.dto.CoordinateDTO;
import ru.kemsu.openenv.dto.GeoCoordDTO;
import ru.kemsu.openenv.model.Coordinate;
import ru.kemsu.openenv.model.GeoCoord;

import java.util.ArrayList;


public class GeoCoordDTOConverter implements Converter<GeoCoordDTO, GeoCoord> {

    @Override
    public GeoCoord convert(final GeoCoordDTO dto) {
        final GeoCoord geoCoord = new GeoCoord();

        ArrayList<Coordinate> coo = new ArrayList<>();
        for (CoordinateDTO coodr : dto.getCoordinate()
        ) {
            Coordinate coordinate = new Coordinate();
            coordinate.setLatitude(coodr.getLatitude());
            coordinate.setLongitude(coodr.getLongitude());
            coo.add(coordinate);
        }
        geoCoord.setCoordinate(coo);

        return geoCoord;
    }
}
