package com.desafio.amedigital.config;

import com.desafio.amedigital.client.SwapiClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ApiConfg {

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    public SwapiClient swapiClient() {
        return new SwapiClient();
    }
}


