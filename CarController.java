package org.example.cars.controller;

import lombok.RequiredArgsConstructor;
import org.example.cars.model.Car;
import org.example.cars.service.CarServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class CarController {

    private CarServiceImpl service;

    @GetMapping(value = "/cars")
    public String getAllCars(Model model) {
        List<Car> cars = service.findAll();
        model.addAttribute("cars", cars);
        return "carInfo";
    }

    @GetMapping(value = "/create")
    public String create(){
        service.create();
        return "index";
    }

    @GetMapping(value = "/drop")
    public String drop(){
        service.drop();
        return "index";
    }

    @GetMapping(value = "/truncate")
    public String truncate(){
        service.deleteAll();
        return "index";
    }

    @GetMapping(value = "/cars/{id}")
    public ResponseEntity<Car> getCarById(@PathVariable("id") long id) {
        return new ResponseEntity<>(service.findById(id).get(), HttpStatus.OK);
    }

    @PutMapping("/cars/{id}")
    public ResponseEntity<Car> updateCarById(@PathVariable long id, @RequestBody Car car){
        Car _car = new Car();
        _car.setId(id);
        _car.setBrand(car.getBrand());
        _car.setModel(car.getModel());
        _car.setNumber(car.getNumber());
        _car.setReleaseYear(car.getReleaseYear());
        service.createCar(_car);
        return new ResponseEntity<>(_car, HttpStatus.OK);
    }

    @DeleteMapping("/cars/{id}")
    public String deleteCarById(@PathVariable("id") long id) {
        service.deleteById(id);
        return "redirect:/cars";
    }

    @PostMapping(value = "/cars")
    public String addCar(Car car) {
        service.createCar(car);
        return "redirect:/cars";
    }

}