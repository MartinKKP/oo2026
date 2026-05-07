package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Bean
    CommandLineRunner initDatabase(AthleteRepository repository) {
        return args -> {
            repository.save(new Athlete("Johannes Erm", "EST", 8445));
            repository.save(new Athlete("Janek Õiglane", "EST", 8524));
            repository.save(new Athlete("Karel Tilga", "EST", 8681));
            repository.save(new Athlete("Kevin Mayer", "FRA", 9126));
            repository.save(new Athlete("Damian Warner", "CAN", 9018));
            repository.save(new Athlete("Leo Neugebauer", "GER", 8836));
            repository.save(new Athlete("Maicel Uibo", "EST", 8604));
            repository.save(new Athlete("Sander Skotheim", "NOR", 8590));
            System.out.println("--- Testandmed laetud! ---");
        };
    }
}