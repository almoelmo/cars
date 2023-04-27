package org.example.cars.service;

import org.example.cars.model.Car;
import org.example.cars.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CarServiceImpl implements CarService{

    @Autowired
    private CarRepository repository;

    public void createCar(Car car) {
        repository.save(car);
    }

    public List<Car> findAll() {
        return repository.findAll();
    }

    public void deleteById(long id) {
        repository.deleteById(id);
    }

    public Optional<Car> findById(long id) {
        return repository.findById(id);
    }

    public void create() {repository.create();}

    public void drop(){ repository.drop();}

    public void deleteAll() {repository.deleteAll();}
}
