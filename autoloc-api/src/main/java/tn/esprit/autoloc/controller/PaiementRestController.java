package tn.esprit.autoloc.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.domain.Paiement;
import tn.esprit.autoloc.service.IPaiementService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/paiement")
@CrossOrigin("*")
public class PaiementRestController {

    private final IPaiementService paiementService;

    @GetMapping({"", "/retrieve-all-paiements"})
    public List<Paiement> retrieveAllPaiements() {
        return paiementService.retrieveAllPaiements();
    }

    @GetMapping({"/{id}", "/retrieve-paiement/{id}"})
    public Paiement retrievePaiement(@PathVariable("id") Long idPaiement) {
        return paiementService.retrievePaiement(idPaiement);
    }

    @PostMapping({"", "/add-paiement"})
    public Paiement addPaiement(@RequestBody Paiement paiement) {
        return paiementService.addPaiement(paiement);
    }

    @PutMapping({"", "/update-paiement"})
    public Paiement updatePaiement(@RequestBody Paiement paiement) {
        return paiementService.updatePaiement(paiement);
    }

    @DeleteMapping({"/{id}", "/remove-paiement/{id}"})
    public void removePaiement(@PathVariable("id") Long idPaiement) {
        paiementService.removePaiement(idPaiement);
    }
}
