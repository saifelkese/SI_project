package tn.esprit.autoloc.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.autoloc.exception.ResourceNotFoundException;
import tn.esprit.autoloc.mapper.ContratMapper;
import tn.esprit.autoloc.repository.ContratRepository;
import tn.esprit.autoloc.web.dto.ContratDTO;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ContratServiceImpl implements IContratService {

    private final ContratRepository contratRepository;
    private final ContratMapper contratMapper;

    @Override
    public List<ContratDTO> retrieveAllContrats() {
        return contratRepository.findAll()
                .stream()
                .map(contratMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public ContratDTO addContrat(ContratDTO contratDTO) {
        return contratMapper.toDto(contratRepository.save(contratMapper.toEntity(contratDTO)));
    }

    @Override
    public ContratDTO updateContrat(ContratDTO contratDTO) {
        return contratMapper.toDto(contratRepository.save(contratMapper.toEntity(contratDTO)));
    }

    @Override
    public ContratDTO retrieveContrat(Long idContrat) {
        return contratRepository.findById(idContrat)
                .map(contratMapper::toDto)
                .orElseThrow(() -> new ResourceNotFoundException("Contrat introuvable avec l'id : " + idContrat));
    }

    @Override
    public void removeContrat(Long idContrat) {
        if (!contratRepository.existsById(idContrat)) {
            throw new ResourceNotFoundException("Contrat introuvable avec l'id : " + idContrat);
        }
        contratRepository.deleteById(idContrat);
    }
}
