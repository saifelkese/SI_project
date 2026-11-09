package tn.esprit.autoloc.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import tn.esprit.autoloc.domain.Client;
import tn.esprit.autoloc.web.dto.ClientDTO;

/**
 * Mapper between {@link Client} entity and {@link ClientDTO}.
 */
@Mapper(componentModel = "spring")
public interface ClientMapper {

    @Mapping(source = "idClient", target = "id")
    ClientDTO toDto(Client client);

    @Mapping(source = "id", target = "idClient")
    @Mapping(target = "reservations", ignore = true)
    Client toEntity(ClientDTO dto);
}
