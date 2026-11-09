package tn.esprit.autoloc.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import tn.esprit.autoloc.domain.Maintenance;
import tn.esprit.autoloc.web.dto.MaintenanceDTO;

@Mapper(componentModel = "spring")
public interface MaintenanceMapper {

    @Mapping(source = "idMaintenance", target = "id")
    @Mapping(source = "vehicule.idVehicule", target = "vehiculeId")
    MaintenanceDTO toDto(Maintenance maintenance);

    @Mapping(source = "id", target = "idMaintenance")
    @Mapping(source = "vehiculeId", target = "vehicule.idVehicule")
    Maintenance toEntity(MaintenanceDTO dto);
}
