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
import tn.esprit.autoloc.service.IVehiculeService;
import tn.esprit.autoloc.web.dto.VehiculeDTO;

import java.util.List;

@Tag(name = "Véhicule", description = "API de gestion des véhicules (opérations CRUD)")
@RestController
@AllArgsConstructor
@RequestMapping("/vehicule")
@CrossOrigin("*")
public class VehiculeRestController {

    private final IVehiculeService vehiculeService;

    @Operation(summary = "Récupérer tous les véhicules", description = "Retourne la liste complète de tous les véhicules.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Liste des véhicules récupérée avec succès"),
            @ApiResponse(responseCode = "500", description = "Erreur interne du serveur")
    })
    @GetMapping({"", "/retrieve-all-vehicules"})
    public List<VehiculeDTO> retrieveAllVehicules() {
        return vehiculeService.retrieveAllVehicules();
    }

    @Operation(summary = "Récupérer un véhicule par son ID", description = "Retourne un véhicule spécifique à partir de son identifiant unique.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Véhicule trouvé"),
            @ApiResponse(responseCode = "404", description = "Véhicule non trouvé"),
            @ApiResponse(responseCode = "500", description = "Erreur interne du serveur")
    })
    @GetMapping({"/{id}", "/retrieve-vehicule/{id}"})
    public VehiculeDTO retrieveVehicule(
            @Parameter(description = "Identifiant unique du véhicule", required = true, example = "1")
            @PathVariable("id") Long idVehicule) {
        return vehiculeService.retrieveVehicule(idVehicule);
    }

    @Operation(summary = "Ajouter un nouveau véhicule", description = "Enregistre un nouveau véhicule dans la base de données.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Véhicule créé avec succès"),
            @ApiResponse(responseCode = "400", description = "Requête invalide / données incorrectes"),
            @ApiResponse(responseCode = "500", description = "Erreur interne du serveur")
    })
    @PostMapping({"", "/add-vehicule"})
    @ResponseStatus(HttpStatus.CREATED)
    public VehiculeDTO addVehicule(@Valid @RequestBody VehiculeDTO vehiculeDTO) {
        return vehiculeService.addVehicule(vehiculeDTO);
    }

    @Operation(summary = "Mettre à jour un véhicule", description = "Modifie les informations d'un véhicule existant.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Véhicule mis à jour avec succès"),
            @ApiResponse(responseCode = "404", description = "Véhicule non trouvé"),
            @ApiResponse(responseCode = "400", description = "Données invalides"),
            @ApiResponse(responseCode = "500", description = "Erreur interne du serveur")
    })
    @PutMapping({"", "/update-vehicule"})
    public VehiculeDTO updateVehicule(@Valid @RequestBody VehiculeDTO vehiculeDTO) {
        return vehiculeService.updateVehicule(vehiculeDTO);
    }

    @Operation(summary = "Supprimer un véhicule", description = "Supprime un véhicule existant par son identifiant unique.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Véhicule supprimé avec succès"),
            @ApiResponse(responseCode = "404", description = "Véhicule non trouvé"),
            @ApiResponse(responseCode = "500", description = "Erreur interne du serveur")
    })
    @DeleteMapping({"/{id}", "/remove-vehicule/{id}"})
    public void removeVehicule(
            @Parameter(description = "Identifiant unique du véhicule à supprimer", required = true, example = "1")
            @PathVariable("id") Long idVehicule) {
        vehiculeService.removeVehicule(idVehicule);
    }
}
