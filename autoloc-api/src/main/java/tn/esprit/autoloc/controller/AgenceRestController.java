package tn.esprit.autoloc.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.domain.Agence;
import tn.esprit.autoloc.service.IAgenceService;

import java.util.List;

@Tag(name = "Agence", description = "API de gestion des agences (opérations CRUD)")
@RestController
@AllArgsConstructor
@RequestMapping("/agence")
@CrossOrigin("*")
public class AgenceRestController {

    private final IAgenceService agenceService;

    @Operation(summary = "Récupérer toutes les agences", description = "Retourne la liste complète de toutes les agences de location.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Liste des agences récupérée avec succès"),
            @ApiResponse(responseCode = "500", description = "Erreur interne du serveur")
    })
    @GetMapping({"", "/retrieve-all-agences"})
    public List<Agence> retrieveAllAgences() {
        return agenceService.retrieveAllAgences();
    }

    @Operation(summary = "Récupérer une agence par son ID", description = "Retourne les détails d'une agence spécifique à partir de son identifiant unique.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Agence trouvée"),
            @ApiResponse(responseCode = "404", description = "Agence non trouvée"),
            @ApiResponse(responseCode = "500", description = "Erreur interne du serveur")
    })
    @GetMapping({"/{id}", "/retrieve-agence/{id}"})
    public Agence retrieveAgence(
            @Parameter(description = "Identifiant unique de l'agence", required = true, example = "1")
            @PathVariable("id") Long idAgence) {
        return agenceService.retrieveAgence(idAgence);
    }

    @Operation(summary = "Ajouter une nouvelle agence", description = "Enregistre une nouvelle agence dans le système.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Agence créée avec succès"),
            @ApiResponse(responseCode = "400", description = "Requête invalide / données incorrectes"),
            @ApiResponse(responseCode = "500", description = "Erreur interne du serveur")
    })
    @PostMapping({"", "/add-agence"})
    @ResponseStatus(HttpStatus.CREATED)
    public Agence addAgence(@RequestBody Agence agence) {
        return agenceService.addAgence(agence);
    }

    @Operation(summary = "Mettre à jour une agence", description = "Modifie les informations d'une agence existante.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Agence mise à jour avec succès"),
            @ApiResponse(responseCode = "404", description = "Agence non trouvée"),
            @ApiResponse(responseCode = "400", description = "Données invalides"),
            @ApiResponse(responseCode = "500", description = "Erreur interne du serveur")
    })
    @PutMapping({"", "/update-agence"})
    public Agence updateAgence(@RequestBody Agence agence) {
        return agenceService.updateAgence(agence);
    }

    @Operation(summary = "Supprimer une agence", description = "Supprime une agence de location via son identifiant unique.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Agence supprimée avec succès"),
            @ApiResponse(responseCode = "404", description = "Agence non trouvée"),
            @ApiResponse(responseCode = "500", description = "Erreur interne du serveur")
    })
    @DeleteMapping({"/{id}", "/remove-agence/{id}"})
    public void removeAgence(
            @Parameter(description = "Identifiant unique de l'agence à supprimer", required = true, example = "1")
            @PathVariable("id") Long idAgence) {
        agenceService.removeAgence(idAgence);
    }
}
