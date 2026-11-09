package tn.esprit.autoloc.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.service.IContratService;
import tn.esprit.autoloc.web.dto.ContratDTO;

import java.util.List;

@Tag(name = "Contrat", description = "API de gestion des contrats (opérations CRUD)")
@RestController
@AllArgsConstructor
@RequestMapping("/contrat")
@CrossOrigin("*")
public class ContratRestController {

    private final IContratService contratService;

    @Operation(summary = "Récupérer tous les contrats", description = "Retourne la liste complète de tous les contrats.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Liste des contrats récupérée avec succès"),
            @ApiResponse(responseCode = "500", description = "Erreur interne du serveur")
    })
    @GetMapping({"", "/retrieve-all-contrats"})
    public List<ContratDTO> retrieveAllContrats() {
        return contratService.retrieveAllContrats();
    }

    @Operation(summary = "Récupérer un contrat par son ID", description = "Retourne les détails d'un contrat spécifique à partir de son identifiant unique.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Contrat trouvé"),
            @ApiResponse(responseCode = "404", description = "Contrat non trouvé"),
            @ApiResponse(responseCode = "500", description = "Erreur interne du serveur")
    })
    @GetMapping({"/{id}", "/retrieve-contrat/{id}"})
    public ContratDTO retrieveContrat(
            @Parameter(description = "Identifiant unique du contrat", required = true, example = "1")
            @PathVariable("id") Long idContrat) {
        return contratService.retrieveContrat(idContrat);
    }

    @Operation(summary = "Ajouter un nouveau contrat", description = "Enregistre un nouveau contrat dans la base de données.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Contrat créé avec succès"),
            @ApiResponse(responseCode = "400", description = "Requête invalide / données incorrectes"),
            @ApiResponse(responseCode = "500", description = "Erreur interne du serveur")
    })
    @PostMapping({"", "/add-contrat"})
    @ResponseStatus(HttpStatus.CREATED)
    public ContratDTO addContrat(@Valid @RequestBody ContratDTO contratDTO) {
        return contratService.addContrat(contratDTO);
    }

    @Operation(summary = "Mettre à jour un contrat", description = "Modifie les informations d'un contrat existant.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Contrat mis à jour avec succès"),
            @ApiResponse(responseCode = "404", description = "Contrat non trouvé"),
            @ApiResponse(responseCode = "400", description = "Données invalides"),
            @ApiResponse(responseCode = "500", description = "Erreur interne du serveur")
    })
    @PutMapping({"", "/update-contrat"})
    public ContratDTO updateContrat(@Valid @RequestBody ContratDTO contratDTO) {
        return contratService.updateContrat(contratDTO);
    }

    @Operation(summary = "Supprimer un contrat", description = "Supprime un contrat de la base de données via son identifiant.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Contrat supprimé avec succès"),
            @ApiResponse(responseCode = "404", description = "Contrat non trouvé"),
            @ApiResponse(responseCode = "500", description = "Erreur interne du serveur")
    })
    @DeleteMapping({"/{id}", "/remove-contrat/{id}"})
    public void removeContrat(
            @Parameter(description = "Identifiant unique du contrat à supprimer", required = true, example = "1")
            @PathVariable("id") Long idContrat) {
        contratService.removeContrat(idContrat);
    }
}
