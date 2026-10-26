package tn.esprit.autoloc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import tn.esprit.autoloc.mapper.VehiculeMapper;

/**
 * Manual configuration to ensure {@link VehiculeMapper} bean is registered.
 * This provides a fallback in case automatic component scanning does not pick up the mapper.
 */
@Configuration
public class ManualMapperConfig {

    @Bean
    public VehiculeMapper vehiculeMapper() {
        return new VehiculeMapper();
    }
}
