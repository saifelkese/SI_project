package tn.esprit.autoloc.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.domain.Agence;
import tn.esprit.autoloc.service.IAgenceService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/agence")
@CrossOrigin("*")
public class AgenceRestController {

    private final IAgenceService agenceService;

    @GetMapping({"", "/retrieve-all-agences"})
    public List<Agence> retrieveAllAgences() {
        return agenceService.retrieveAllAgences();
    }

    @GetMapping({"/{id}", "/retrieve-agence/{id}"})
    public Agence retrieveAgence(@PathVariable("id") Long idAgence) {
        return agenceService.retrieveAgence(idAgence);
    }

    @PostMapping({"", "/add-agence"})
    public Agence addAgence(@RequestBody Agence agence) {
        return agenceService.addAgence(agence);
    }

    @PutMapping({"", "/update-agence"})
    public Agence updateAgence(@RequestBody Agence agence) {
        return agenceService.updateAgence(agence);
    }

    @DeleteMapping({"/{id}", "/remove-agence/{id}"})
    public void removeAgence(@PathVariable("id") Long idAgence) {
        agenceService.removeAgence(idAgence);
    }
}
