package org.example.cars.service;

import org.example.cars.model.Car;

import java.util.List;
import java.util.Optional;

public interface CarService {

    void createCar(Car car);
    void deleteById(long id);
    Optional<Car> findById(long id);
    List<Car> findAll();
}
