package tn.esprit.autoloc.mapper;

import org.springframework.stereotype.Component;
import tn.esprit.autoloc.domain.Vehicule;
import tn.esprit.autoloc.web.dto.VehiculeDTO;

/**
 * Mapper for converting between {@link Vehicule} entity and {@link VehiculeDTO}.
 */
@Component
public class VehiculeMapper {

    /**
     * Convert {@link Vehicule} entity to {@link VehiculeDTO}.
     */
    public VehiculeDTO toDto(Vehicule vehicule) {
        if (vehicule == null) {
            return null;
        }
        VehiculeDTO dto = new VehiculeDTO();
        dto.setId(vehicule.getIdVehicule());
        dto.setImmatriculation(vehicule.getImmatriculation());
        dto.setMarque(vehicule.getMarque());
        dto.setModele(vehicule.getModele());
        dto.setCategorie(vehicule.getCategorie());
        dto.setTarifJournalier(vehicule.getTarifJournalier());
        dto.setStatut(vehicule.getStatut());
        if (vehicule.getAgence() != null) {
            dto.setAgenceId(vehicule.getAgence().getIdAgence());
        }
        return dto;
    }

    /**
     * Convert {@link VehiculeDTO} to {@link Vehicule} entity.
     */
    public Vehicule toEntity(VehiculeDTO dto) {
        if (dto == null) {
            return null;
        }
        Vehicule vehicule = new Vehicule();
        vehicule.setIdVehicule(dto.getId());
        vehicule.setImmatriculation(dto.getImmatriculation());
        vehicule.setMarque(dto.getMarque());
        vehicule.setModele(dto.getModele());
        vehicule.setCategorie(dto.getCategorie());
        vehicule.setTarifJournalier(dto.getTarifJournalier());
        vehicule.setStatut(dto.getStatut());
        // Association with Agence should be handled in service layer
        return vehicule;
    }
}
