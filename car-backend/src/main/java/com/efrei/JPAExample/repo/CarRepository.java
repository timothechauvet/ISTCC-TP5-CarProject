package com.efrei.JPAExample.repo;

import java.util.List;

import com.efrei.JPAExample.model.Car;
import org.springframework.data.repository.CrudRepository;

public interface CarRepository extends CrudRepository<Car, Long> {
	
	List<Car> findByPlateNumber(String plateNumber);

}
