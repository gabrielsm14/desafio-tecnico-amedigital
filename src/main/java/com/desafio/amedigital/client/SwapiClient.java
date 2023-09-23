package com.desafio.amedigital.client;

import com.desafio.amedigital.domain.Planet;
import com.desafio.amedigital.dto.FilmsDTO;
import com.desafio.amedigital.dto.SwapiResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.List;

public class SwapiClient {

    @Autowired
    private RestTemplate restTemplate;

    public List<String> getFilmAppearences(Planet planet) {
        ResponseEntity<SwapiResponseDTO> planetResponse = restTemplate.getForEntity("https://swapi.dev/api/planets/?search=" + planet.getName(), SwapiResponseDTO.class);
        SwapiResponseDTO swapiResponse = planetResponse.getBody();
        FilmsDTO filmsDTO = swapiResponse.getResults().get(0);
        List<String> filmes = filmsDTO.getFilms();
        return filmes;
    }
}
