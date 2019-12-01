package ru.kemsu.openenv.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.kemsu.openenv.converter.factory.ConverterFactory;
import ru.kemsu.openenv.dto.UserDTO;
import ru.kemsu.openenv.model.User;


@Component
public class ConverterFacade {

    @Autowired
    private ConverterFactory converterFactory;

    public User convert(final UserDTO dto) {
        return (User) converterFactory.getConverter(dto.getClass()).convert(dto);
    }
}
