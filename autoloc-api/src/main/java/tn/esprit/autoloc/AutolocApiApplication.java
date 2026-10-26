package tn.esprit.autoloc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Main Spring Boot application class.
 * Explicitly sets scanBasePackages to include the mapper package (tn.esprit.autoloc.mapper)
 * and any other sub‑packages under the base package.
 */
@SpringBootApplication(scanBasePackages = "tn.esprit.autoloc")
public class AutolocApiApplication {
    public static void main(String[] args) {
        SpringApplication.run(AutolocApiApplication.class, args);
    }
}
