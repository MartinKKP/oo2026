package com.example.car.controller;

import com.example.car.mudel.Car;
import com.example.car.service.CarService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cars")
public class CarController {

    private final CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping
    public List<Car> getCars() {
        return carService.getAllCars();
    }

    @PostMapping
    public Car addCar(@Valid @RequestBody Car car) {
        return carService.addCar(car);
    }
}
