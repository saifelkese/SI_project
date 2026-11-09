package tn.esprit.autoloc.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import tn.esprit.autoloc.domain.Paiement;
import tn.esprit.autoloc.web.dto.PaiementDTO;

@Mapper(componentModel = "spring")
public interface PaiementMapper {

    @Mapping(source = "idPaiement", target = "id")
    @Mapping(source = "contrat.idContrat", target = "contratId")
    PaiementDTO toDto(Paiement paiement);

    @Mapping(source = "id", target = "idPaiement")
    @Mapping(source = "contratId", target = "contrat.idContrat")
    Paiement toEntity(PaiementDTO dto);
}
