package tn.esprit.autoloc.service;

import tn.esprit.autoloc.web.dto.ContratDTO;
import java.util.List;

public interface IContratService {
    List<ContratDTO> retrieveAllContrats();
    ContratDTO addContrat(ContratDTO contratDTO);
    ContratDTO updateContrat(ContratDTO contratDTO);
    ContratDTO retrieveContrat(Long idContrat);
    void removeContrat(Long idContrat);
}
