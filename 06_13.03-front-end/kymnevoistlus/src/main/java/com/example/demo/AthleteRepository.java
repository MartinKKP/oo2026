package com.example.demo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AthleteRepository extends JpaRepository<Athlete, Long> {
    // Filtreerimine riigi järgi (tõstutundetu) koos lehekülgede ja sorteerimisega
    Page<Athlete> findByCountryIgnoreCase(String country, Pageable pageable);
}