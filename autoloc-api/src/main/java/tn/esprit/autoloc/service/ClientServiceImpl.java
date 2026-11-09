package tn.esprit.autoloc.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.autoloc.exception.ResourceNotFoundException;
import tn.esprit.autoloc.mapper.ClientMapper;
import tn.esprit.autoloc.repository.ClientRepository;
import tn.esprit.autoloc.web.dto.ClientDTO;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ClientServiceImpl implements IClientService {

    private final ClientRepository clientRepository;
    private final ClientMapper clientMapper;

    @Override
    public List<ClientDTO> retrieveAllClients() {
        return clientRepository.findAll()
                .stream()
                .map(clientMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public ClientDTO addClient(ClientDTO clientDTO) {
        return clientMapper.toDto(clientRepository.save(clientMapper.toEntity(clientDTO)));
    }

    @Override
    public ClientDTO updateClient(ClientDTO clientDTO) {
        return clientMapper.toDto(clientRepository.save(clientMapper.toEntity(clientDTO)));
    }

    @Override
    public ClientDTO retrieveClient(Long idClient) {
        return clientRepository.findById(idClient)
                .map(clientMapper::toDto)
                .orElseThrow(() -> new ResourceNotFoundException("Client introuvable avec l'id : " + idClient));
    }

    @Override
    public void removeClient(Long idClient) {
        if (!clientRepository.existsById(idClient)) {
            throw new ResourceNotFoundException("Client introuvable avec l'id : " + idClient);
        }
        clientRepository.deleteById(idClient);
    }
}
