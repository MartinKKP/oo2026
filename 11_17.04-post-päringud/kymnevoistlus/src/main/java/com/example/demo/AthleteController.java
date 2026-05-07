package com.example.demo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/results")
@CrossOrigin(origins = "*")
public class AthleteController {

    private final AthleteRepository repository;

    public AthleteController(AthleteRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public Page<Athlete> getResults(
            @RequestParam(required = false) String country,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size,
            @RequestParam(defaultValue = "totalPoints") String sortBy,
            @RequestParam(defaultValue = "desc") String direction
    ) {
        // Luuakse sorteerimise reegel back-endis
        Sort sort = direction.equalsIgnoreCase("desc")
                ? Sort.by(sortBy).descending()
                : Sort.by(sortBy).ascending();

        // Luuakse pagination objekt
        Pageable pageable = PageRequest.of(page, size, sort);

        // Filtreerimine toimub samuti back-endis
        if (country != null && !country.trim().isEmpty()) {
            return repository.findByCountryIgnoreCase(country, pageable);
        }
        return repository.findAll(pageable);
    }

    @PostMapping
    public Athlete addAthlete(@RequestBody Athlete athlete) {
        return repository.save(athlete);
    }
}