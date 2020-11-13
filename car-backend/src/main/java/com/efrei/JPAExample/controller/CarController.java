package com.efrei.JPAExample.controller;

import com.efrei.JPAExample.model.Car;
import com.efrei.JPAExample.repo.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class RestWebService {
	CarRepository carRepository;

	@Autowired
	public RestWebService(CarRepository carRepository) {
		super();
		this.carRepository = carRepository;
	}
	
	@GetMapping("/cities")
	public Iterable<Car> getCities(){
		return carRepository.findAll();
	}

	@PostMapping("/cities")
	@Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
	public void addCar(@RequestBody Car car) throws Exception {
		carRepository.save(car);
		if(car.getName().equals("London")){
			throw new Exception();
		}
	}
	
	
}
