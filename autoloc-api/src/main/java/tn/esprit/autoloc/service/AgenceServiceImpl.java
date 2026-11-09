package tn.esprit.autoloc.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.autoloc.exception.ResourceNotFoundException;
import tn.esprit.autoloc.mapper.AgenceMapper;
import tn.esprit.autoloc.repository.AgenceRepository;
import tn.esprit.autoloc.web.dto.AgenceDTO;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class AgenceServiceImpl implements IAgenceService {

    private final AgenceRepository agenceRepository;
    private final AgenceMapper agenceMapper;

    @Override
    public List<AgenceDTO> retrieveAllAgences() {
        return agenceRepository.findAll()
                .stream()
                .map(agenceMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public AgenceDTO addAgence(AgenceDTO agenceDTO) {
        return agenceMapper.toDto(agenceRepository.save(agenceMapper.toEntity(agenceDTO)));
    }

    @Override
    public AgenceDTO updateAgence(AgenceDTO agenceDTO) {
        return agenceMapper.toDto(agenceRepository.save(agenceMapper.toEntity(agenceDTO)));
    }

    @Override
    public AgenceDTO retrieveAgence(Long idAgence) {
        return agenceRepository.findById(idAgence)
                .map(agenceMapper::toDto)
                .orElseThrow(() -> new ResourceNotFoundException("Agence introuvable avec l'id : " + idAgence));
    }

    @Override
    public void removeAgence(Long idAgence) {
        if (!agenceRepository.existsById(idAgence)) {
            throw new ResourceNotFoundException("Agence introuvable avec l'id : " + idAgence);
        }
        agenceRepository.deleteById(idAgence);
    }
}
