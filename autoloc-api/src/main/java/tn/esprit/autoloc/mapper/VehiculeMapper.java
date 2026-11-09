package tn.esprit.autoloc.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import tn.esprit.autoloc.domain.Vehicule;
import tn.esprit.autoloc.web.dto.VehiculeDTO;

@Mapper(componentModel = "spring")
public interface VehiculeMapper {

    @Mapping(source = "idVehicule", target = "id")
    @Mapping(source = "agence.idAgence", target = "agenceId")
    VehiculeDTO toDto(Vehicule vehicule);

    @Mapping(source = "id", target = "idVehicule")
    @Mapping(source = "agenceId", target = "agence.idAgence")
    @Mapping(target = "reservations", ignore = true)
    @Mapping(target = "equipements", ignore = true)
    Vehicule toEntity(VehiculeDTO dto);
}
