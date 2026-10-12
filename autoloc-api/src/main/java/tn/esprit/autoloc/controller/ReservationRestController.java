package tn.esprit.autoloc.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.domain.Reservation;
import tn.esprit.autoloc.service.IReservationService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/reservation")
@CrossOrigin("*")
public class ReservationRestController {

    private final IReservationService reservationService;

    @GetMapping({"", "/retrieve-all-reservations"})
    public List<Reservation> retrieveAllReservations() {
        return reservationService.retrieveAllReservations();
    }

    @GetMapping({"/{id}", "/retrieve-reservation/{id}"})
    public Reservation retrieveReservation(@PathVariable("id") Long idReservation) {
        return reservationService.retrieveReservation(idReservation);
    }

    @PostMapping({"", "/add-reservation"})
    public Reservation addReservation(@RequestBody Reservation reservation) {
        return reservationService.addReservation(reservation);
    }

    @PutMapping({"", "/update-reservation"})
    public Reservation updateReservation(@RequestBody Reservation reservation) {
        return reservationService.updateReservation(reservation);
    }

    @DeleteMapping({"/{id}", "/remove-reservation/{id}"})
    public void removeReservation(@PathVariable("id") Long idReservation) {
        reservationService.removeReservation(idReservation);
    }
}
