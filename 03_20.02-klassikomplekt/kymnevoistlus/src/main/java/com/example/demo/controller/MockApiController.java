package com.example.demo.controller;

import com.example.demo.model.Judge;
import com.example.demo.model.Location;
import com.example.demo.service.MockApiService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MockApiController {

    private final MockApiService mockApiService;

    public MockApiController(MockApiService mockApiService) {
        this.mockApiService = mockApiService;
    }

    @GetMapping("/api/judges")
    public List<Judge> judges() {
        return mockApiService.getJudges();
    }

    @GetMapping("/api/locations")
    public List<Location> locations() {
        return mockApiService.getLocations();
    }
}