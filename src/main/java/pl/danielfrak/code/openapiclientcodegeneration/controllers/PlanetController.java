package pl.danielfrak.code.openapiclientcodegeneration.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.danielfrak.code.openapiclientcodegeneration.domain.Planet;
import pl.danielfrak.code.openapiclientcodegeneration.domain.PlanetRepository;

import java.util.List;

@Tag(name = "Planets")
@RestController
@RequestMapping("planets")
public class PlanetController {

    private final PlanetRepository repository;

    public PlanetController(PlanetRepository repository) {
        this.repository = repository;
    }

    @Operation(description = "Returns a list of all available planets")
    @GetMapping
    public ResponseEntity<List<Planet>> findAllPlanets() {
        return ResponseEntity.ok(repository.findAll());
    }

    @Operation(description = "Returns information about a particular planet")
    @GetMapping("{id}")
    public ResponseEntity<Planet> findPlanet(@PathVariable Long id) {
        return repository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @Operation(description = "Creates a new planet")
    @PostMapping
    public ResponseEntity<Planet> savePlanet(@RequestBody Planet planet) {
        return ResponseEntity.ok(repository.save(planet));
    }
}
