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
import tn.esprit.autoloc.service.IMaintenanceService;
import tn.esprit.autoloc.web.dto.MaintenanceDTO;

import java.util.List;

@Tag(name = "Maintenance", description = "API de gestion des maintenances (opérations CRUD)")
@RestController
@AllArgsConstructor
@RequestMapping("/maintenance")
@CrossOrigin("*")
public class MaintenanceRestController {

    private final IMaintenanceService maintenanceService;

    @Operation(summary = "Récupérer toutes les maintenances", description = "Retourne la liste complète de toutes les maintenances.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Liste des maintenances récupérée avec succès"),
            @ApiResponse(responseCode = "500", description = "Erreur interne du serveur")
    })
    @GetMapping({"", "/retrieve-all-maintenances"})
    public List<MaintenanceDTO> retrieveAllMaintenances() {
        return maintenanceService.retrieveAllMaintenances();
    }

    @Operation(summary = "Récupérer une maintenance par son ID", description = "Retourne les détails d'une maintenance spécifique à partir de son identifiant unique.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Maintenance trouvée"),
            @ApiResponse(responseCode = "404", description = "Maintenance non trouvée"),
            @ApiResponse(responseCode = "500", description = "Erreur interne du serveur")
    })
    @GetMapping({"/{id}", "/retrieve-maintenance/{id}"})
    public MaintenanceDTO retrieveMaintenance(
            @Parameter(description = "Identifiant unique de la maintenance", required = true, example = "1")
            @PathVariable("id") Long idMaintenance) {
        return maintenanceService.retrieveMaintenance(idMaintenance);
    }

    @Operation(summary = "Ajouter une nouvelle maintenance", description = "Enregistre une nouvelle maintenance dans la base de données.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Maintenance créée avec succès"),
            @ApiResponse(responseCode = "400", description = "Requête invalide / données incorrectes"),
            @ApiResponse(responseCode = "500", description = "Erreur interne du serveur")
    })
    @PostMapping({"", "/add-maintenance"})
    @ResponseStatus(HttpStatus.CREATED)
    public MaintenanceDTO addMaintenance(@Valid @RequestBody MaintenanceDTO maintenanceDTO) {
        return maintenanceService.addMaintenance(maintenanceDTO);
    }

    @Operation(summary = "Mettre à jour une maintenance", description = "Modifie les informations d'une maintenance existante.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Maintenance mise à jour avec succès"),
            @ApiResponse(responseCode = "404", description = "Maintenance non trouvée"),
            @ApiResponse(responseCode = "400", description = "Données invalides"),
            @ApiResponse(responseCode = "500", description = "Erreur interne du serveur")
    })
    @PutMapping({"", "/update-maintenance"})
    public MaintenanceDTO updateMaintenance(@Valid @RequestBody MaintenanceDTO maintenanceDTO) {
        return maintenanceService.updateMaintenance(maintenanceDTO);
    }

    @Operation(summary = "Supprimer une maintenance", description = "Supprime une maintenance de la base de données via son identifiant.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Maintenance supprimée avec succès"),
            @ApiResponse(responseCode = "404", description = "Maintenance non trouvée"),
            @ApiResponse(responseCode = "500", description = "Erreur interne du serveur")
    })
    @DeleteMapping({"/{id}", "/remove-maintenance/{id}"})
    public void removeMaintenance(
            @Parameter(description = "Identifiant unique de la maintenance à supprimer", required = true, example = "1")
            @PathVariable("id") Long idMaintenance) {
        maintenanceService.removeMaintenance(idMaintenance);
    }
}
