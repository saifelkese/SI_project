package tn.esprit.autoloc.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.domain.Contrat;
import tn.esprit.autoloc.service.IContratService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/contrat")
@CrossOrigin("*")
public class ContratRestController {

    private final IContratService contratService;

    @GetMapping({"", "/retrieve-all-contrats"})
    public List<Contrat> retrieveAllContrats() {
        return contratService.retrieveAllContrats();
    }

    @GetMapping({"/{id}", "/retrieve-contrat/{id}"})
    public Contrat retrieveContrat(@PathVariable("id") Long idContrat) {
        return contratService.retrieveContrat(idContrat);
    }

    @PostMapping({"", "/add-contrat"})
    public Contrat addContrat(@RequestBody Contrat contrat) {
        return contratService.addContrat(contrat);
    }

    @PutMapping({"", "/update-contrat"})
    public Contrat updateContrat(@RequestBody Contrat contrat) {
        return contratService.updateContrat(contrat);
    }

    @DeleteMapping({"/{id}", "/remove-contrat/{id}"})
    public void removeContrat(@PathVariable("id") Long idContrat) {
        contratService.removeContrat(idContrat);
    }
}
