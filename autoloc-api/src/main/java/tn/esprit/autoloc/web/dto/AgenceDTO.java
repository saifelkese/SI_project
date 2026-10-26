package tn.esprit.autoloc.web.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * DTO for {@link tn.esprit.autoloc.domain.Agence}.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AgenceDTO {
    private Long id;

    @NotBlank(message = "Nom is mandatory")
    private String nom;

    @NotBlank(message = "Ville is mandatory")
    private String ville;

    @NotBlank(message = "Adresse is mandatory")
    private String adresse;

    @NotBlank(message = "Telephone is mandatory")
    private String telephone;
}
