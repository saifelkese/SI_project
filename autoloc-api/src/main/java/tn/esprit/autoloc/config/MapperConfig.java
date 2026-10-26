package tn.esprit.autoloc.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Configuration class to ensure that mapper packages are scanned and registered as Spring beans.
 * This is required because the mapper package may not be automatically detected by the default
 * component scan of the main application class.
 */
@Configuration
@ComponentScan(basePackages = "tn.esprit.autoloc.mapper")
public class MapperConfig {
    // No explicit beans needed; the @ComponentScan will pick up @Component classes like VehiculeMapper.
}
