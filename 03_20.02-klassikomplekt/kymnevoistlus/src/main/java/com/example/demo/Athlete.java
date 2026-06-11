package com.example.demo;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Athlete {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Nimi on kohustuslik")
    @Size(min = 2, message = "Võistleja nimi")
    private String name;

    @NotBlank(message = "Sisetsta riik")
    @Pattern(regexp = "^[A-Z]{3}$", message = "Riigi nimi, Lühendat.")
    private String country;

    @Min(value = 0, message = "Punktisumma ei saa olla negatiivne")
    private int totalPoints;

    public Athlete(String name, String country, int totalPoints) {
        this.name = name;
        this.country = country;
        this.totalPoints = totalPoints;
    }
}