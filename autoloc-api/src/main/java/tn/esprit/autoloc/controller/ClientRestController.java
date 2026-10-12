package tn.esprit.autoloc.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.domain.Client;
import tn.esprit.autoloc.service.IClientService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/client")
@CrossOrigin("*")
public class ClientRestController {

    private final IClientService clientService;

    @GetMapping({"", "/retrieve-all-clients"})
    public List<Client> retrieveAllClients() {
        return clientService.retrieveAllClients();
    }

    @GetMapping({"/{id}", "/retrieve-client/{id}"})
    public Client retrieveClient(@PathVariable("id") Long idClient) {
        return clientService.retrieveClient(idClient);
    }

    @PostMapping({"", "/add-client"})
    public Client addClient(@RequestBody Client client) {
        return clientService.addClient(client);
    }

    @PutMapping({"", "/update-client"})
    public Client updateClient(@RequestBody Client client) {
        return clientService.updateClient(client);
    }

    @DeleteMapping({"/{id}", "/remove-client/{id}"})
    public void removeClient(@PathVariable("id") Long idClient) {
        clientService.removeClient(idClient);
    }
}
