package tn.esprit.autoloc.mapper;

import org.springframework.stereotype.Component;
import tn.esprit.autoloc.domain.Vehicule;

/**
 * Simple mapper placeholder for Vehicule entity. Currently it does not perform any conversion
 * but exists so that Spring can inject it into {@link tn.esprit.autoloc.controller.VehiculeRestController}.
 * You can extend it with DTO conversion methods when needed.
 */
@Component
public class VehiculeMapper {
    // Example conversion method (can be expanded later)
    public Vehicule toEntity(Vehicule vehicule) {
        return vehicule;
    }

    public Vehicule toDto(Vehicule vehicule) {
        return vehicule;
    }
}
