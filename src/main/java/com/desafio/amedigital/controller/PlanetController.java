package com.desafio.amedigital.controller;

import com.desafio.amedigital.domain.Planet;
import com.desafio.amedigital.service.PlanetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/planets")
public class PlanetController {

    @Autowired
    private PlanetService planetService;

    @PostMapping
    public ResponseEntity<Planet> create(@RequestBody Planet planet) throws Exception {
        Planet newPlanet = planetService.createPlanet(planet);

        return ResponseEntity.status(HttpStatus.CREATED).body(newPlanet);
    }

    @GetMapping
    public List<Planet> list() {
        return planetService.list();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Planet> listById(@PathVariable Long id){
        Optional<Planet> planetById = planetService.findById(id);

        return ResponseEntity.status(HttpStatus.OK).body(planetById.get());
    }

    @GetMapping("/name")
    public ResponseEntity<Planet> listByName(@RequestParam("name") String name){
        Optional<Planet> planetByname = planetService.findByName(name);

        return ResponseEntity.status(HttpStatus.OK).body(planetByname.get());
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long id) {
        planetService.deletePlanet(id);
    }
}
