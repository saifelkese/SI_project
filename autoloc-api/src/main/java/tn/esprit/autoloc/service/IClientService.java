package tn.esprit.autoloc.service;

import tn.esprit.autoloc.web.dto.ClientDTO;
import java.util.List;

public interface IClientService {
    List<ClientDTO> retrieveAllClients();
    ClientDTO addClient(ClientDTO clientDTO);
    ClientDTO updateClient(ClientDTO clientDTO);
    ClientDTO retrieveClient(Long idClient);
    void removeClient(Long idClient);
}
