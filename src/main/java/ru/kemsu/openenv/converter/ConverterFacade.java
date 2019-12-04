package ru.kemsu.openenv.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.kemsu.openenv.converter.factory.ConverterFactory;
import ru.kemsu.openenv.dto.MapDTO;
import ru.kemsu.openenv.dto.OrganisationDTO;
import ru.kemsu.openenv.dto.UserDTO;
import ru.kemsu.openenv.model.Organisation;
import ru.kemsu.openenv.model.User;


@Component
public class ConverterFacade {

    @Autowired
    private ConverterFactory converterFactory;

    public User convert(final UserDTO dto) {
        return (User) converterFactory.getConverter(dto.getClass()).convert(dto);
    }

    public Organisation convert(final OrganisationDTO dto) {
        return (Organisation) converterFactory.getConverter(dto.getClass()).convert(dto);
    }

    public Organisation convert(final MapDTO dto) {
        return (Organisation) converterFactory.getConverter(dto.getClass()).convert(dto);
    }
}
