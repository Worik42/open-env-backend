package ru.kemsu.openenv.converter.factory;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import ru.kemsu.openenv.converter.dto.MapDTOConverter;
import ru.kemsu.openenv.converter.dto.UserDTOConverter;
import ru.kemsu.openenv.dto.MapDTO;
import ru.kemsu.openenv.dto.UserDTO;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;


@Component
public class ConverterFactory {

    private Map<Object, Converter> converters;

    public ConverterFactory() {

    }

    @PostConstruct
    public void init() {
        converters = new HashMap<>();
        converters.put(UserDTO.class, new UserDTOConverter());
        converters.put(MapDTO.class, new MapDTOConverter());
    }

    public Converter getConverter(final Object type) {
        return converters.get(type);
    }
}
