package com.efrei.JPAExample;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "car")
public class Car {
	// Table in Database
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@Column(name = "plateNumber")
	private String plateNumber;
	@Column(name = "model")
	private String model;
	@Column(name = "price")
	private int price;
	@Column(name = "numberOfDays")
	private int numberOfDays;
	@Column(name = "rented")
	private boolean rented;

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

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getNumberOfDays() {
		return numberOfDays;
	}

	public void setNumberOfDays(int numberOfDays) {
		this.numberOfDays = numberOfDays;
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
		return "Car [id=" + id + ", plateNumber=" + plateNumber +
				", model=" + model + ", price=" + price +
				", numberOfDays=" + numberOfDays + ", rented=" + rented + "]";
	}
}
