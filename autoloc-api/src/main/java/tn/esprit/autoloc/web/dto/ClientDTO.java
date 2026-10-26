package tn.esprit.autoloc.web.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

/**
 * DTO for {@link tn.esprit.autoloc.domain.Client}.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClientDTO {
    private Long id;

    @NotBlank(message = "Nom is mandatory")
    private String nom;

    @NotBlank(message = "Prenom is mandatory")
    private String prenom;

    @Email(message = "Email should be valid")
    @NotBlank(message = "Email is mandatory")
    private String email;

    @NotBlank(message = "Telephone is mandatory")
    private String telephone;

    @NotBlank(message = "Numéro de permis is mandatory")
    private String numPermis;

    @NotNull(message = "Date d'inscription is mandatory")
    @PastOrPresent(message = "Date d'inscription must be in the past or present")
    private LocalDate dateInscription;
}
