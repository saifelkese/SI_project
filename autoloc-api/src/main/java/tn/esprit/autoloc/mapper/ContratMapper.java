package tn.esprit.autoloc.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import tn.esprit.autoloc.domain.Contrat;
import tn.esprit.autoloc.web.dto.ContratDTO;

@Mapper(componentModel = "spring")
public interface ContratMapper {

    @Mapping(source = "idContrat", target = "id")
    @Mapping(source = "reservation.idReservation", target = "reservationId")
    ContratDTO toDto(Contrat contrat);

    @Mapping(source = "id", target = "idContrat")
    @Mapping(source = "reservationId", target = "reservation.idReservation")
    @Mapping(target = "paiements", ignore = true)
    Contrat toEntity(ContratDTO dto);
}
