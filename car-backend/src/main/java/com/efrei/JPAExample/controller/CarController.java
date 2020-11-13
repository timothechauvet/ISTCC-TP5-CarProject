package com.efrei.JPAExample.controller;

import com.efrei.JPAExample.Car;
import com.efrei.JPAExample.repo.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class CarController {

    @Autowired
    CarRepository repository;

    @GetMapping("/cars")
    public List<Car> getAllCars() {
        System.out.println("Get all Cars...");

        List<Car> cars = new ArrayList<>();
        repository.findAll().forEach(cars::add);

        return cars;
    }

    @PostMapping(value = "/cars/create")
    public Car postCar(@RequestBody Car car) {
        return repository.save(new Car(car.getPlateNumber()));
    }

    @DeleteMapping("/cars/{id}")
    public ResponseEntity<String> deleteCar(@PathVariable("id") long id) {
        System.out.println("Delete Car with ID = " + id + "...");

        repository.deleteById(id);

        return new ResponseEntity<>("Car has been deleted!", HttpStatus.OK);
    }

    @DeleteMapping("/cars/delete")
    public ResponseEntity<String> deleteAllCars() {
        System.out.println("Delete All Cars...");

        repository.deleteAll();

        return new ResponseEntity<>("All cars have been deleted!", HttpStatus.OK);
    }

    @GetMapping(value = "cars/plateNumber/{plateNumber}")
    public List<Car> findByPlateNumber(@PathVariable String plateNumber) {
        return repository.findByPlateNumber(plateNumber);
    }

    @PutMapping("/cars/{id}")
    public ResponseEntity<Car> updateCar(@PathVariable("id") long id, @RequestBody Car car) {
        System.out.println("Update Car with ID = " + id + "...");

        Optional<Car> carData = repository.findById(id);

        if (carData.isPresent()) {
            Car _car = carData.get();
            _car.setPlateNumber(car.getPlateNumber());
            _car.setRented(car.isRented());
            return new ResponseEntity<>(repository.save(_car), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}