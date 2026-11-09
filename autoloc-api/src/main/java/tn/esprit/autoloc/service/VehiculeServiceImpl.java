package tn.esprit.autoloc.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.autoloc.exception.ResourceNotFoundException;
import tn.esprit.autoloc.mapper.VehiculeMapper;
import tn.esprit.autoloc.repository.VehiculeRepository;
import tn.esprit.autoloc.web.dto.VehiculeDTO;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class VehiculeServiceImpl implements IVehiculeService {

    private final VehiculeRepository vehiculeRepository;
    private final VehiculeMapper vehiculeMapper;

    @Override
    public List<VehiculeDTO> retrieveAllVehicules() {
        return vehiculeRepository.findAll()
                .stream()
                .map(vehiculeMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public VehiculeDTO addVehicule(VehiculeDTO vehiculeDTO) {
        return vehiculeMapper.toDto(vehiculeRepository.save(vehiculeMapper.toEntity(vehiculeDTO)));
    }

    @Override
    public VehiculeDTO updateVehicule(VehiculeDTO vehiculeDTO) {
        return vehiculeMapper.toDto(vehiculeRepository.save(vehiculeMapper.toEntity(vehiculeDTO)));
    }

    @Override
    public VehiculeDTO retrieveVehicule(Long idVehicule) {
        return vehiculeRepository.findById(idVehicule)
                .map(vehiculeMapper::toDto)
                .orElseThrow(() -> new ResourceNotFoundException("Véhicule introuvable avec l'id : " + idVehicule));
    }

    @Override
    public void removeVehicule(Long idVehicule) {
        if (!vehiculeRepository.existsById(idVehicule)) {
            throw new ResourceNotFoundException("Véhicule introuvable avec l'id : " + idVehicule);
        }
        vehiculeRepository.deleteById(idVehicule);
    }
}
