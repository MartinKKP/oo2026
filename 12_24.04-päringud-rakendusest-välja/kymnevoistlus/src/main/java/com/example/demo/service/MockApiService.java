package com.example.demo.service;

import com.example.demo.model.Judge;
import com.example.demo.model.Location;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.List;

@Service
public class MockApiService {

    private final RestClient restClient = RestClient.create();

    public List<Judge> getJudges() {

        return restClient.get()
                .uri("https://69fcb72d30ad0a6fd1c00b74.mockapi.io/judges")
                .retrieve()
                .body(new ParameterizedTypeReference<List<Judge>>() {});
    }

    public List<Location> getLocations() {

        return restClient.get()
                .uri("https://69fcb72d30ad0a6fd1c00b74.mockapi.io/locations")
                .retrieve()
                .body(new ParameterizedTypeReference<List<Location>>() {});
    }
}