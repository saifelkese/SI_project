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
import tn.esprit.autoloc.service.IEmployeService;
import tn.esprit.autoloc.web.dto.EmployeDTO;

import java.util.List;

@Tag(name = "Employé", description = "API de gestion des employés (opérations CRUD)")
@RestController
@AllArgsConstructor
@RequestMapping("/employe")
@CrossOrigin("*")
public class EmployeRestController {

    private final IEmployeService employeService;

    @Operation(summary = "Récupérer tous les employés", description = "Retourne la liste complète de tous les employés.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Liste des employés récupérée avec succès"),
            @ApiResponse(responseCode = "500", description = "Erreur interne du serveur")
    })
    @GetMapping({"", "/retrieve-all-employes"})
    public List<EmployeDTO> retrieveAllEmployes() {
        return employeService.retrieveAllEmployes();
    }

    @Operation(summary = "Récupérer un employé par son ID", description = "Retourne les détails d'un employé spécifique à partir de son identifiant unique.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Employé trouvé"),
            @ApiResponse(responseCode = "404", description = "Employé non trouvé"),
            @ApiResponse(responseCode = "500", description = "Erreur interne du serveur")
    })
    @GetMapping({"/{id}", "/retrieve-employe/{id}"})
    public EmployeDTO retrieveEmploye(
            @Parameter(description = "Identifiant unique de l'employé", required = true, example = "1")
            @PathVariable("id") Long idEmploye) {
        return employeService.retrieveEmploye(idEmploye);
    }

    @Operation(summary = "Ajouter un nouvel employé", description = "Enregistre un nouvel employé dans la base de données.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Employé créé avec succès"),
            @ApiResponse(responseCode = "400", description = "Requête invalide / données incorrectes"),
            @ApiResponse(responseCode = "500", description = "Erreur interne du serveur")
    })
    @PostMapping({"", "/add-employe"})
    @ResponseStatus(HttpStatus.CREATED)
    public EmployeDTO addEmploye(@Valid @RequestBody EmployeDTO employeDTO) {
        return employeService.addEmploye(employeDTO);
    }

    @Operation(summary = "Mettre à jour un employé", description = "Modifie les informations d'un employé existant.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Employé mis à jour avec succès"),
            @ApiResponse(responseCode = "404", description = "Employé non trouvé"),
            @ApiResponse(responseCode = "400", description = "Données invalides"),
            @ApiResponse(responseCode = "500", description = "Erreur interne du serveur")
    })
    @PutMapping({"", "/update-employe"})
    public EmployeDTO updateEmploye(@Valid @RequestBody EmployeDTO employeDTO) {
        return employeService.updateEmploye(employeDTO);
    }

    @Operation(summary = "Supprimer un employé", description = "Supprime un employé de la base de données via son identifiant.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Employé supprimé avec succès"),
            @ApiResponse(responseCode = "404", description = "Employé non trouvé"),
            @ApiResponse(responseCode = "500", description = "Erreur interne du serveur")
    })
    @DeleteMapping({"/{id}", "/remove-employe/{id}"})
    public void removeEmploye(
            @Parameter(description = "Identifiant unique de l'employé à supprimer", required = true, example = "1")
            @PathVariable("id") Long idEmploye) {
        employeService.removeEmploye(idEmploye);
    }
}
