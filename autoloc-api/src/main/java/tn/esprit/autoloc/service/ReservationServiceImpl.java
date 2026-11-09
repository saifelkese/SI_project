package tn.esprit.autoloc.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.autoloc.exception.ResourceNotFoundException;
import tn.esprit.autoloc.mapper.ReservationMapper;
import tn.esprit.autoloc.repository.ReservationRepository;
import tn.esprit.autoloc.web.dto.ReservationDTO;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ReservationServiceImpl implements IReservationService {

    private final ReservationRepository reservationRepository;
    private final ReservationMapper reservationMapper;

    @Override
    public List<ReservationDTO> retrieveAllReservations() {
        return reservationRepository.findAll()
                .stream()
                .map(reservationMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public ReservationDTO addReservation(ReservationDTO reservationDTO) {
        return reservationMapper.toDto(reservationRepository.save(reservationMapper.toEntity(reservationDTO)));
    }

    @Override
    public ReservationDTO updateReservation(ReservationDTO reservationDTO) {
        return reservationMapper.toDto(reservationRepository.save(reservationMapper.toEntity(reservationDTO)));
    }

    @Override
    public ReservationDTO retrieveReservation(Long idReservation) {
        return reservationRepository.findById(idReservation)
                .map(reservationMapper::toDto)
                .orElseThrow(() -> new ResourceNotFoundException("Réservation introuvable avec l'id : " + idReservation));
    }

    @Override
    public void removeReservation(Long idReservation) {
        if (!reservationRepository.existsById(idReservation)) {
            throw new ResourceNotFoundException("Réservation introuvable avec l'id : " + idReservation);
        }
        reservationRepository.deleteById(idReservation);
    }
}
