package tn.esprit.autoloc.web.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import tn.esprit.autoloc.domain.CategorieVehicule;
import tn.esprit.autoloc.domain.StatutVehicule;
import java.math.BigDecimal;

/**
 * Data Transfer Object for {@link tn.esprit.autoloc.domain.Vehicule}.
 * <p>
 * Only the fields required for API communication are exposed. The mapping
 * between the entity and this DTO is performed by {@code VehiculeMapper} using
 * MapStruct.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class VehiculeDTO {
    private Long id;

    @NotBlank(message = "Immatriculation is mandatory")
    private String immatriculation;

    @NotBlank(message = "Marque is mandatory")
    private String marque;

    @NotBlank(message = "Modele is mandatory")
    private String modele;

    @NotNull(message = "Categorie is mandatory")
    private CategorieVehicule categorie;

    @NotNull(message = "Tarif journalier is mandatory")
    @Positive(message = "Tarif must be positive")
    private BigDecimal tarifJournalier;

    @NotNull(message = "Statut is mandatory")
    private StatutVehicule statut;

    /**
     * Identifier of the associated {@code Agence}. This is a flat reference to avoid
     * sending the whole {@code Agence} entity in the API response.
     */
    private Long agenceId;
}
