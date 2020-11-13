package com.efrei.JPAExample.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.jms.*;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@Entity
@Table(name = "car")
public class Car implements Serializable {
	// Table in Database
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@Column(name = "plateNumber")
	private String plateNumber;
	@Column(name = "rented")
	private boolean rented;

	// Constructor
	public Car(String plateNumber) {
		this.plateNumber = plateNumber;
		this.rented = false;
	}

	public Car() {
		this.plateNumber = "plateNumber";
		this.rented = false;
	}

	//Getters and setters
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getPlateNumber() {
		return plateNumber;
	}

	public void setPlateNumber(String plateNumber) {
		this.plateNumber = plateNumber;
	}

	public boolean isRented() {
		return rented;
	}

	public void setRented(boolean rented) {
		this.rented = rented;
	}

	// Methods
	@Override
	public String toString() {
		return "Car [id=" + id + ", plateNumber=" + plateNumber + ", rented=" + rented + "]";
	}
}
