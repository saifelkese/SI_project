package tn.esprit.autoloc.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.domain.Employe;
import tn.esprit.autoloc.service.IEmployeService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/employe")
@CrossOrigin("*")
public class EmployeRestController {

    private final IEmployeService employeService;

    @GetMapping({"", "/retrieve-all-employes"})
    public List<Employe> retrieveAllEmployes() {
        return employeService.retrieveAllEmployes();
    }

    @GetMapping({"/{id}", "/retrieve-employe/{id}"})
    public Employe retrieveEmploye(@PathVariable("id") Long idEmploye) {
        return employeService.retrieveEmploye(idEmploye);
    }

    @PostMapping({"", "/add-employe"})
    public Employe addEmploye(@RequestBody Employe employe) {
        return employeService.addEmploye(employe);
    }

    @PutMapping({"", "/update-employe"})
    public Employe updateEmploye(@RequestBody Employe employe) {
        return employeService.updateEmploye(employe);
    }

    @DeleteMapping({"/{id}", "/remove-employe/{id}"})
    public void removeEmploye(@PathVariable("id") Long idEmploye) {
        employeService.removeEmploye(idEmploye);
    }
}
