package ru.kemsu.openenv.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.kemsu.openenv.converter.factory.ConverterFactory;
import ru.kemsu.openenv.dto.MapDTO;
import ru.kemsu.openenv.dto.OrganizationDTO;
import ru.kemsu.openenv.dto.UserDTO;
import ru.kemsu.openenv.model.Coordinate;
import ru.kemsu.openenv.model.GeoCoord;
import ru.kemsu.openenv.model.User;


@Component
public class ConverterFacade {

    private final ConverterFactory converterFactory;

    @Autowired
    public ConverterFacade(ConverterFactory converterFactory) {
        this.converterFactory = converterFactory;
    }

    public User convert(final UserDTO dto) {
        return (User) converterFactory.getConverter(dto.getClass()).convert(dto);
    }

    public Organisation convert(final OrganizationDTO dto) {
        return (Organisation) converterFactory.getConverter(dto.getClass()).convert(dto);
    }

    public Organisation convert(final MapDTO dto) {
        return (Organisation) converterFactory.getConverter(dto.getClass()).convert(dto);
    }

    public GeoCoord convert(final GeoCoordDTO dto) {
        return (GeoCoord) converterFactory.getConverter(dto.getClass()).convert(dto);
    }

    public Coordinate convert(final CoordinateDTO dto) {
        return (Coordinate) converterFactory.getConverter(dto.getClass()).convert(dto);
    }


}
