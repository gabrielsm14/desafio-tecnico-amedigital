package com.desafio.amedigital.service;

import com.desafio.amedigital.client.SwapiClient;
import com.desafio.amedigital.domain.Planet;
import com.desafio.amedigital.exception.PlanetAlreadyExistsException;
import com.desafio.amedigital.repository.PlanetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlanetService {

    @Autowired
    private PlanetRepository planetRepository;

    @Autowired
    private SwapiClient swapiClient;

    public Planet createPlanet(Planet planet) throws Exception {
        if (findByName(planet.getName()).isPresent()) {
            throw new PlanetAlreadyExistsException();
        }

        List<String> filmes = swapiClient.getFilmAppearences(planet);
        planet.setFilms(filmes);

        return planetRepository.save(planet);
    }

    public List<Planet> list() {
        return planetRepository.findAll();
    }

    public Optional<Planet> findById(Long id) {
        return planetRepository.findById(id);
    }

    public Optional<Planet> findByName(String name) {
        return planetRepository.findByName(name);
    }

    public void deletePlanet(Long id) {
        planetRepository.deleteById(id);
    }
}
