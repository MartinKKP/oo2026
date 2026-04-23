package com.example.car.service;

import com.example.car.mudel.Car;
import com.example.car.exception.CarException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarService {

    private final List<Car> cars = new ArrayList<>();

    public List<Car> getAllCars() {
        return cars;
    }

    public Car addCar(Car car) {

        if (cars.stream().anyMatch(c ->
                c.getnumbrimark().equals(car.getnumbrimark()))) {
            throw new CarException("Duplikaat registreerimisnumber");
        }

        if (car.getaasta() > 2026) {
            throw new CarException("Auto ei tohi olla tulevikust");
        }

        if (car.gethind() > 1_000_000) {
            throw new CarException("Hind liiga suur");
        }

        if (car.getBrand().equalsIgnoreCase("Test")) {
            throw new CarException("Keelatud automark");
        }

        if (car.getmudel().length() < 2) {
            throw new CarException("Mudeli nimi liiga lühike");
        }

        cars.add(car);
        return car;
    }
}
