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
import tn.esprit.autoloc.service.IReservationService;
import tn.esprit.autoloc.web.dto.ReservationDTO;

import java.util.List;

@Tag(name = "Réservation", description = "API de gestion des réservations (opérations CRUD)")
@RestController
@AllArgsConstructor
@RequestMapping("/reservation")
@CrossOrigin("*")
public class ReservationRestController {

    private final IReservationService reservationService;

    @Operation(summary = "Récupérer toutes les réservations", description = "Retourne la liste complète de toutes les réservations.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Liste des réservations récupérée avec succès"),
            @ApiResponse(responseCode = "500", description = "Erreur interne du serveur")
    })
    @GetMapping({"", "/retrieve-all-reservations"})
    public List<ReservationDTO> retrieveAllReservations() {
        return reservationService.retrieveAllReservations();
    }

    @Operation(summary = "Récupérer une réservation par son ID", description = "Retourne les détails d'une réservation spécifique à partir de son identifiant unique.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Réservation trouvée"),
            @ApiResponse(responseCode = "404", description = "Réservation non trouvée"),
            @ApiResponse(responseCode = "500", description = "Erreur interne du serveur")
    })
    @GetMapping({"/{id}", "/retrieve-reservation/{id}"})
    public ReservationDTO retrieveReservation(
            @Parameter(description = "Identifiant unique de la réservation", required = true, example = "1")
            @PathVariable("id") Long idReservation) {
        return reservationService.retrieveReservation(idReservation);
    }

    @Operation(summary = "Ajouter une nouvelle réservation", description = "Enregistre une nouvelle réservation dans la base de données.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Réservation créée avec succès"),
            @ApiResponse(responseCode = "400", description = "Requête invalide / données incorrectes"),
            @ApiResponse(responseCode = "500", description = "Erreur interne du serveur")
    })
    @PostMapping({"", "/add-reservation"})
    @ResponseStatus(HttpStatus.CREATED)
    public ReservationDTO addReservation(@Valid @RequestBody ReservationDTO reservationDTO) {
        return reservationService.addReservation(reservationDTO);
    }

    @Operation(summary = "Mettre à jour une réservation", description = "Modifie les informations d'une réservation existante.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Réservation mise à jour avec succès"),
            @ApiResponse(responseCode = "404", description = "Réservation non trouvée"),
            @ApiResponse(responseCode = "400", description = "Données invalides"),
            @ApiResponse(responseCode = "500", description = "Erreur interne du serveur")
    })
    @PutMapping({"", "/update-reservation"})
    public ReservationDTO updateReservation(@Valid @RequestBody ReservationDTO reservationDTO) {
        return reservationService.updateReservation(reservationDTO);
    }

    @Operation(summary = "Supprimer une réservation", description = "Supprime une réservation de la base de données via son identifiant.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Réservation supprimée avec succès"),
            @ApiResponse(responseCode = "404", description = "Réservation non trouvée"),
            @ApiResponse(responseCode = "500", description = "Erreur interne du serveur")
    })
    @DeleteMapping({"/{id}", "/remove-reservation/{id}"})
    public void removeReservation(
            @Parameter(description = "Identifiant unique de la réservation à supprimer", required = true, example = "1")
            @PathVariable("id") Long idReservation) {
        reservationService.removeReservation(idReservation);
    }
}
