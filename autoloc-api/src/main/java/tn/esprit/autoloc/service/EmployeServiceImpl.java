package tn.esprit.autoloc.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.autoloc.exception.ResourceNotFoundException;
import tn.esprit.autoloc.mapper.EmployeMapper;
import tn.esprit.autoloc.repository.EmployeRepository;
import tn.esprit.autoloc.web.dto.EmployeDTO;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class EmployeServiceImpl implements IEmployeService {

    private final EmployeRepository employeRepository;
    private final EmployeMapper employeMapper;

    @Override
    public List<EmployeDTO> retrieveAllEmployes() {
        return employeRepository.findAll()
                .stream()
                .map(employeMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public EmployeDTO addEmploye(EmployeDTO employeDTO) {
        return employeMapper.toDto(employeRepository.save(employeMapper.toEntity(employeDTO)));
    }

    @Override
    public EmployeDTO updateEmploye(EmployeDTO employeDTO) {
        return employeMapper.toDto(employeRepository.save(employeMapper.toEntity(employeDTO)));
    }

    @Override
    public EmployeDTO retrieveEmploye(Long idEmploye) {
        return employeRepository.findById(idEmploye)
                .map(employeMapper::toDto)
                .orElseThrow(() -> new ResourceNotFoundException("Employé introuvable avec l'id : " + idEmploye));
    }

    @Override
    public void removeEmploye(Long idEmploye) {
        if (!employeRepository.existsById(idEmploye)) {
            throw new ResourceNotFoundException("Employé introuvable avec l'id : " + idEmploye);
        }
        employeRepository.deleteById(idEmploye);
    }
}
