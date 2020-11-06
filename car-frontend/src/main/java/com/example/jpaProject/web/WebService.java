package com.example.jpaProject.web;

import com.example.jpaProject.model.Person;
import com.example.jpaProject.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebService {
    PersonRepository personRepository;

    @Autowired
    public WebService(PersonRepository personRepository) {
        super();
        this.personRepository = personRepository;
    }

    @GetMapping("/persons")
    public Iterable<Person> getPersons() {
        return personRepository.findAll();
    }

    @PostMapping("/persons")
    @Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
    public void addPerson(@RequestBody Person person) throws Exception {
        personRepository.save(person);
    }
}
