package tn.esprit.autoloc.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import tn.esprit.autoloc.domain.Vehicule;
import tn.esprit.autoloc.web.dto.VehiculeDTO;

/**
 * MapStruct mapper for converting between {@link Vehicule} entity and {@link VehiculeDTO}.
 */
@Mapper(componentModel = "spring")
public interface VehiculeMapper {
    VehiculeMapper INSTANCE = Mappers.getMapper(VehiculeMapper.class);

    @Mapping(source = "idVehicule", target = "id")
    @Mapping(source = "agence.idAgence", target = "agenceId")
    VehiculeDTO toDto(Vehicule vehicule);

    @Mapping(source = "id", target = "idVehicule")
    @Mapping(source = "agenceId", target = "agence.idAgence")
    Vehicule toEntity(VehiculeDTO dto);
}
