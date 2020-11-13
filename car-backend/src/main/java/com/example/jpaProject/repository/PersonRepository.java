package com.example.jpaProject.repository;

import com.example.jpaProject.model.Person;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PersonRepository extends CrudRepository<Person, Long> {
    List<Person> findByName(String name);
}