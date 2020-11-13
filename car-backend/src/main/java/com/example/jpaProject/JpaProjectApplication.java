package com.example.jpaProject;

import com.example.jpaProject.model.Car;
import com.example.jpaProject.model.Person;
import com.example.jpaProject.repository.PersonRepository;
import com.example.jpaProject.model.Rent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.text.SimpleDateFormat;
import java.util.Date;

@SpringBootApplication
public class JpaProjectApplication {
	private static final Logger log = LoggerFactory.getLogger(JpaProjectApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(JpaProjectApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo (PersonRepository repository) {
		return (args) -> {
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			Date date = dateFormat.parse("2018-10-09");
			log.info(date.toString());

			Person michel 	= new Person("Michel", 12);
			Car toyota		= new Car();
			Rent toyota_mic	= new Rent(dateFormat.parse("2000-01-01"), dateFormat.parse("2020-01-01"));

			toyota_mic.setPerson(michel);
			toyota_mic.setVehicule(toyota);
			repository.save(michel);

			repository.findByName("Michel").forEach(person -> {
				log.info(person.toString());
			});
		};
	}
}
