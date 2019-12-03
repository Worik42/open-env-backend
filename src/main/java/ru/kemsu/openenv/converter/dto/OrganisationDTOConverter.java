package ru.kemsu.openenv.converter.dto;

import org.springframework.core.convert.converter.Converter;
import ru.kemsu.openenv.dto.OrganisationDTO;
import ru.kemsu.openenv.model.Authority;
import ru.kemsu.openenv.model.Organisation;

import java.util.ArrayList;
import java.util.List;


public class OrganisationDTOConverter implements Converter<OrganisationDTO, Organisation> {

    @Override
    public Organisation convert(final OrganisationDTO dto) {
        final Organisation organisation = new Organisation();

        organisation.setName(dto.setName());
        organisation.setPosition(dto.getPosition());
        organisation.setDescriptions(dto.getDescriptions());
        organisation.setAccountNonExpired(false);
        organisation.setCredentialsNonExpired(false);
        organisation.setEnabled(true);

        List<Authority> authorities = new ArrayList<>();
        authorities.add(Authority.ROLE_USER);
        organisation.setAuthorities(authorities);
        return organisation;
    }
}
