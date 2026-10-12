package tn.esprit.autoloc.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.domain.Equipement;
import tn.esprit.autoloc.service.IEquipementService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/equipement")
@CrossOrigin("*")
public class EquipementRestController {

    private final IEquipementService equipementService;

    @GetMapping({"", "/retrieve-all-equipements"})
    public List<Equipement> retrieveAllEquipements() {
        return equipementService.retrieveAllEquipements();
    }

    @GetMapping({"/{id}", "/retrieve-equipement/{id}"})
    public Equipement retrieveEquipement(@PathVariable("id") Long idEquipement) {
        return equipementService.retrieveEquipement(idEquipement);
    }

    @PostMapping({"", "/add-equipement"})
    public Equipement addEquipement(@RequestBody Equipement equipement) {
        return equipementService.addEquipement(equipement);
    }

    @PutMapping({"", "/update-equipement"})
    public Equipement updateEquipement(@RequestBody Equipement equipement) {
        return equipementService.updateEquipement(equipement);
    }

    @DeleteMapping({"/{id}", "/remove-equipement/{id}"})
    public void removeEquipement(@PathVariable("id") Long idEquipement) {
        equipementService.removeEquipement(idEquipement);
    }
}
