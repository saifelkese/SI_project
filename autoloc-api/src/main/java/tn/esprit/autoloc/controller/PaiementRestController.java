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
import tn.esprit.autoloc.service.IPaiementService;
import tn.esprit.autoloc.web.dto.PaiementDTO;

import java.util.List;

@Tag(name = "Paiement", description = "API de gestion des paiements (opérations CRUD)")
@RestController
@AllArgsConstructor
@RequestMapping("/paiement")
@CrossOrigin("*")
public class PaiementRestController {

    private final IPaiementService paiementService;

    @Operation(summary = "Récupérer tous les paiements", description = "Retourne la liste complète de tous les paiements.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Liste des paiements récupérée avec succès"),
            @ApiResponse(responseCode = "500", description = "Erreur interne du serveur")
    })
    @GetMapping({"", "/retrieve-all-paiements"})
    public List<PaiementDTO> retrieveAllPaiements() {
        return paiementService.retrieveAllPaiements();
    }

    @Operation(summary = "Récupérer un paiement par son ID", description = "Retourne les détails d'un paiement spécifique à partir de son identifiant unique.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Paiement trouvé"),
            @ApiResponse(responseCode = "404", description = "Paiement non trouvé"),
            @ApiResponse(responseCode = "500", description = "Erreur interne du serveur")
    })
    @GetMapping({"/{id}", "/retrieve-paiement/{id}"})
    public PaiementDTO retrievePaiement(
            @Parameter(description = "Identifiant unique du paiement", required = true, example = "1")
            @PathVariable("id") Long idPaiement) {
        return paiementService.retrievePaiement(idPaiement);
    }

    @Operation(summary = "Ajouter un nouveau paiement", description = "Enregistre un nouveau paiement dans la base de données.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Paiement créé avec succès"),
            @ApiResponse(responseCode = "400", description = "Requête invalide / données incorrectes"),
            @ApiResponse(responseCode = "500", description = "Erreur interne du serveur")
    })
    @PostMapping({"", "/add-paiement"})
    @ResponseStatus(HttpStatus.CREATED)
    public PaiementDTO addPaiement(@Valid @RequestBody PaiementDTO paiementDTO) {
        return paiementService.addPaiement(paiementDTO);
    }

    @Operation(summary = "Mettre à jour un paiement", description = "Modifie les informations d'un paiement existant.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Paiement mis à jour avec succès"),
            @ApiResponse(responseCode = "404", description = "Paiement non trouvé"),
            @ApiResponse(responseCode = "400", description = "Données invalides"),
            @ApiResponse(responseCode = "500", description = "Erreur interne du serveur")
    })
    @PutMapping({"", "/update-paiement"})
    public PaiementDTO updatePaiement(@Valid @RequestBody PaiementDTO paiementDTO) {
        return paiementService.updatePaiement(paiementDTO);
    }

    @Operation(summary = "Supprimer un paiement", description = "Supprime un paiement de la base de données via son identifiant.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Paiement supprimé avec succès"),
            @ApiResponse(responseCode = "404", description = "Paiement non trouvé"),
            @ApiResponse(responseCode = "500", description = "Erreur interne du serveur")
    })
    @DeleteMapping({"/{id}", "/remove-paiement/{id}"})
    public void removePaiement(
            @Parameter(description = "Identifiant unique du paiement à supprimer", required = true, example = "1")
            @PathVariable("id") Long idPaiement) {
        paiementService.removePaiement(idPaiement);
    }
}
