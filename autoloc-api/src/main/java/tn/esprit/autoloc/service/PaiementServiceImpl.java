package tn.esprit.autoloc.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.autoloc.exception.ResourceNotFoundException;
import tn.esprit.autoloc.mapper.PaiementMapper;
import tn.esprit.autoloc.repository.PaiementRepository;
import tn.esprit.autoloc.web.dto.PaiementDTO;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class PaiementServiceImpl implements IPaiementService {

    private final PaiementRepository paiementRepository;
    private final PaiementMapper paiementMapper;

    @Override
    public List<PaiementDTO> retrieveAllPaiements() {
        return paiementRepository.findAll()
                .stream()
                .map(paiementMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public PaiementDTO addPaiement(PaiementDTO paiementDTO) {
        return paiementMapper.toDto(paiementRepository.save(paiementMapper.toEntity(paiementDTO)));
    }

    @Override
    public PaiementDTO updatePaiement(PaiementDTO paiementDTO) {
        return paiementMapper.toDto(paiementRepository.save(paiementMapper.toEntity(paiementDTO)));
    }

    @Override
    public PaiementDTO retrievePaiement(Long idPaiement) {
        return paiementRepository.findById(idPaiement)
                .map(paiementMapper::toDto)
                .orElseThrow(() -> new ResourceNotFoundException("Paiement introuvable avec l'id : " + idPaiement));
    }

    @Override
    public void removePaiement(Long idPaiement) {
        if (!paiementRepository.existsById(idPaiement)) {
            throw new ResourceNotFoundException("Paiement introuvable avec l'id : " + idPaiement);
        }
        paiementRepository.deleteById(idPaiement);
    }
}
