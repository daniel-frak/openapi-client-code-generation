package pl.danielfrak.code.openapiclientcodegeneration.domain;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PlanetRepository {

    private final List<Planet> planets;

    public PlanetRepository() {
        planets = new ArrayList<>();
        planets.add(new Planet(1L, "Omicron Persei 8", true));
        planets.add(new Planet(2L, "Alpha Nine", false));
        planets.add(new Planet(3L, "Dagobah", true));
        planets.add(new Planet(4L, "Caprica", true));
    }

    public List<Planet> findAll() {
        return new ArrayList<>(planets);
    }

    public Optional<Planet> findById(Long id) {
        return planets.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst();
    }

    public Planet save(Planet planet) {
        planets.add(planet);
        return planet;
    }
}
