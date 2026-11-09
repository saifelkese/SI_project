package tn.esprit.autoloc.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.autoloc.exception.ResourceNotFoundException;
import tn.esprit.autoloc.mapper.EquipementMapper;
import tn.esprit.autoloc.repository.EquipementRepository;
import tn.esprit.autoloc.web.dto.EquipementDTO;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class EquipementServiceImpl implements IEquipementService {

    private final EquipementRepository equipementRepository;
    private final EquipementMapper equipementMapper;

    @Override
    public List<EquipementDTO> retrieveAllEquipements() {
        return equipementRepository.findAll()
                .stream()
                .map(equipementMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public EquipementDTO addEquipement(EquipementDTO equipementDTO) {
        return equipementMapper.toDto(equipementRepository.save(equipementMapper.toEntity(equipementDTO)));
    }

    @Override
    public EquipementDTO updateEquipement(EquipementDTO equipementDTO) {
        return equipementMapper.toDto(equipementRepository.save(equipementMapper.toEntity(equipementDTO)));
    }

    @Override
    public EquipementDTO retrieveEquipement(Long idEquipement) {
        return equipementRepository.findById(idEquipement)
                .map(equipementMapper::toDto)
                .orElseThrow(() -> new ResourceNotFoundException("Équipement introuvable avec l'id : " + idEquipement));
    }

    @Override
    public void removeEquipement(Long idEquipement) {
        if (!equipementRepository.existsById(idEquipement)) {
            throw new ResourceNotFoundException("Équipement introuvable avec l'id : " + idEquipement);
        }
        equipementRepository.deleteById(idEquipement);
    }
}
