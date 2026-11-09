package tn.esprit.autoloc.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import tn.esprit.autoloc.domain.Reservation;
import tn.esprit.autoloc.web.dto.ReservationDTO;

@Mapper(componentModel = "spring")
public interface ReservationMapper {

    @Mapping(source = "idReservation", target = "id")
    @Mapping(source = "vehicule.idVehicule", target = "vehiculeId")
    @Mapping(source = "client.idClient", target = "clientId")
    ReservationDTO toDto(Reservation reservation);

    @Mapping(source = "id", target = "idReservation")
    @Mapping(source = "vehiculeId", target = "vehicule.idVehicule")
    @Mapping(source = "clientId", target = "client.idClient")
    @Mapping(target = "contrat", ignore = true)
    Reservation toEntity(ReservationDTO dto);
}
