package tn.esprit.autoloc.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.domain.Maintenance;
import tn.esprit.autoloc.service.IMaintenanceService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/maintenance")
@CrossOrigin("*")
public class MaintenanceRestController {

    private final IMaintenanceService maintenanceService;

    @GetMapping({"", "/retrieve-all-maintenances"})
    public List<Maintenance> retrieveAllMaintenances() {
        return maintenanceService.retrieveAllMaintenances();
    }

    @GetMapping({"/{id}", "/retrieve-maintenance/{id}"})
    public Maintenance retrieveMaintenance(@PathVariable("id") Long idMaintenance) {
        return maintenanceService.retrieveMaintenance(idMaintenance);
    }

    @PostMapping({"", "/add-maintenance"})
    public Maintenance addMaintenance(@RequestBody Maintenance maintenance) {
        return maintenanceService.addMaintenance(maintenance);
    }

    @PutMapping({"", "/update-maintenance"})
    public Maintenance updateMaintenance(@RequestBody Maintenance maintenance) {
        return maintenanceService.updateMaintenance(maintenance);
    }

    @DeleteMapping({"/{id}", "/remove-maintenance/{id}"})
    public void removeMaintenance(@PathVariable("id") Long idMaintenance) {
        maintenanceService.removeMaintenance(idMaintenance);
    }
}
