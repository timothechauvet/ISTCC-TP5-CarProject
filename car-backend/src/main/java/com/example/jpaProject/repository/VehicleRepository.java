package com.example.jpaProject.repository;

import com.example.jpaProject.model.Vehicle;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface VehicleRepository extends CrudRepository<Vehicle, Long> {
    List<Vehicle> findByNumberOfSeats(int numberOfSeats);
}