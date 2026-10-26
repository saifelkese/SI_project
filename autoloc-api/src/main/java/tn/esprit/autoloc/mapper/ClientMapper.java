package tn.esprit.autoloc.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import tn.esprit.autoloc.domain.Client;
import tn.esprit.autoloc.web.dto.ClientDTO;

/**
 * Mapper between {@link Client} entity and {@link ClientDTO}.
 */
@Mapper(componentModel = "spring")
public interface ClientMapper {
    ClientMapper INSTANCE = Mappers.getMapper(ClientMapper.class);

    @Mapping(source = "idClient", target = "id")
    ClientDTO toDto(Client client);

    @Mapping(source = "id", target = "idClient")
    Client toEntity(ClientDTO dto);
}
