package tn.esprit.autoloc.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.autoloc.exception.ResourceNotFoundException;
import tn.esprit.autoloc.mapper.MaintenanceMapper;
import tn.esprit.autoloc.repository.MaintenanceRepository;
import tn.esprit.autoloc.web.dto.MaintenanceDTO;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class MaintenanceServiceImpl implements IMaintenanceService {

    private final MaintenanceRepository maintenanceRepository;
    private final MaintenanceMapper maintenanceMapper;

    @Override
    public List<MaintenanceDTO> retrieveAllMaintenances() {
        return maintenanceRepository.findAll()
                .stream()
                .map(maintenanceMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public MaintenanceDTO addMaintenance(MaintenanceDTO maintenanceDTO) {
        return maintenanceMapper.toDto(maintenanceRepository.save(maintenanceMapper.toEntity(maintenanceDTO)));
    }

    @Override
    public MaintenanceDTO updateMaintenance(MaintenanceDTO maintenanceDTO) {
        return maintenanceMapper.toDto(maintenanceRepository.save(maintenanceMapper.toEntity(maintenanceDTO)));
    }

    @Override
    public MaintenanceDTO retrieveMaintenance(Long idMaintenance) {
        return maintenanceRepository.findById(idMaintenance)
                .map(maintenanceMapper::toDto)
                .orElseThrow(() -> new ResourceNotFoundException("Maintenance introuvable avec l'id : " + idMaintenance));
    }

    @Override
    public void removeMaintenance(Long idMaintenance) {
        if (!maintenanceRepository.existsById(idMaintenance)) {
            throw new ResourceNotFoundException("Maintenance introuvable avec l'id : " + idMaintenance);
        }
        maintenanceRepository.deleteById(idMaintenance);
    }
}
