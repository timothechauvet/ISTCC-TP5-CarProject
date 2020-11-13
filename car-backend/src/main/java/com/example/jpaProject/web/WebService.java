package com.example.jpaProject.web;

import com.example.jpaProject.model.Person;
import com.example.jpaProject.model.Vehicle;
import com.example.jpaProject.repository.PersonRepository;
import com.example.jpaProject.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class WebService {
    @Autowired
    PersonRepository personRepository;
    @Autowired
    VehicleRepository vehicleRepository;

    public WebService(PersonRepository personRepository) {
        super();
        this.personRepository = personRepository;
    }

    @GetMapping("/persons")
    public List<Person> getPersons() {
        System.out.println("Getting all persons");
        List<Person> persons = new ArrayList<>();
        //Search for all persons
        personRepository.findAll().forEach(persons::add);

        return persons;
    }

    @PostMapping("/persons/create")
    @Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
    public ResponseEntity<String> addPerson(@RequestBody Person person) throws Exception {
        System.out.println("Add new person : " + person.toString());
        Person _person = personRepository.save(new Person(person.getName(), person.getAge()));
        return new ResponseEntity<>("Person has been added", HttpStatus.OK);
    }

    @DeleteMapping("/persons/{ID}")
    public ResponseEntity<String> removePerson(@PathVariable("ID") long id) throws Exception {
        personRepository.deleteById(id);
        return new ResponseEntity<>("Person " + id + " has been removed", HttpStatus.OK);
    }


    @GetMapping("/cars")
    public List<Vehicle> getCars() {
        System.out.println("Getting all vehicles");
        List<Vehicle> vehicles = new ArrayList<>();
        //Search for all persons
        vehicleRepository.findAll().forEach(vehicles::add);

        return vehicles;
    }

    @PostMapping("/cars/create")
    @Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
    public ResponseEntity<String> addVehicle(@RequestBody Vehicle vehicle) throws Exception {
        System.out.println("Add new person : " + vehicle.toString());
        Vehicle _vehicle = vehicleRepository.save(vehicle);
        return new ResponseEntity<>("Vehicle has been added", HttpStatus.OK);
    }

    @DeleteMapping("/cars/{ID}")
    public ResponseEntity<String> removeVehicle(@PathVariable("ID") long plate) throws Exception {
        personRepository.deleteById(plate);
        return new ResponseEntity<>("Vehicle " + plate + " has been removed", HttpStatus.OK);
    }
}
