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
import tn.esprit.autoloc.service.IEquipementService;
import tn.esprit.autoloc.web.dto.EquipementDTO;

import java.util.List;

@Tag(name = "Équipement", description = "API de gestion des équipements (opérations CRUD)")
@RestController
@AllArgsConstructor
@RequestMapping("/equipement")
@CrossOrigin("*")
public class EquipementRestController {

    private final IEquipementService equipementService;

    @Operation(summary = "Récupérer tous les équipements", description = "Retourne la liste complète de tous les équipements.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Liste des équipements récupérée avec succès"),
            @ApiResponse(responseCode = "500", description = "Erreur interne du serveur")
    })
    @GetMapping({"", "/retrieve-all-equipements"})
    public List<EquipementDTO> retrieveAllEquipements() {
        return equipementService.retrieveAllEquipements();
    }

    @Operation(summary = "Récupérer un équipement par son ID", description = "Retourne les détails d'un équipement spécifique à partir de son identifiant unique.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Équipement trouvé"),
            @ApiResponse(responseCode = "404", description = "Équipement non trouvé"),
            @ApiResponse(responseCode = "500", description = "Erreur interne du serveur")
    })
    @GetMapping({"/{id}", "/retrieve-equipement/{id}"})
    public EquipementDTO retrieveEquipement(
            @Parameter(description = "Identifiant unique de l'équipement", required = true, example = "1")
            @PathVariable("id") Long idEquipement) {
        return equipementService.retrieveEquipement(idEquipement);
    }

    @Operation(summary = "Ajouter un nouvel équipement", description = "Enregistre un nouvel équipement dans la base de données.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Équipement créé avec succès"),
            @ApiResponse(responseCode = "400", description = "Requête invalide / données incorrectes"),
            @ApiResponse(responseCode = "500", description = "Erreur interne du serveur")
    })
    @PostMapping({"", "/add-equipement"})
    @ResponseStatus(HttpStatus.CREATED)
    public EquipementDTO addEquipement(@Valid @RequestBody EquipementDTO equipementDTO) {
        return equipementService.addEquipement(equipementDTO);
    }

    @Operation(summary = "Mettre à jour un équipement", description = "Modifie les informations d'un équipement existant.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Équipement mis à jour avec succès"),
            @ApiResponse(responseCode = "404", description = "Équipement non trouvé"),
            @ApiResponse(responseCode = "400", description = "Données invalides"),
            @ApiResponse(responseCode = "500", description = "Erreur interne du serveur")
    })
    @PutMapping({"", "/update-equipement"})
    public EquipementDTO updateEquipement(@Valid @RequestBody EquipementDTO equipementDTO) {
        return equipementService.updateEquipement(equipementDTO);
    }

    @Operation(summary = "Supprimer un équipement", description = "Supprime un équipement de la base de données via son identifiant.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Équipement supprimé avec succès"),
            @ApiResponse(responseCode = "404", description = "Équipement non trouvé"),
            @ApiResponse(responseCode = "500", description = "Erreur interne du serveur")
    })
    @DeleteMapping({"/{id}", "/remove-equipement/{id}"})
    public void removeEquipement(
            @Parameter(description = "Identifiant unique de l'équipement à supprimer", required = true, example = "1")
            @PathVariable("id") Long idEquipement) {
        equipementService.removeEquipement(idEquipement);
    }
}
