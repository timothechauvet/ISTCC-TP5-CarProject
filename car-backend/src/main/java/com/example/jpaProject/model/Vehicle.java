package com.example.jpaProject.model;

import javax.persistence.*;

@Entity
@Table(name = "VEHICULE")
public class Vehicle {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long plateNumber;

	@Column(name = "MAX_WEIGHT")
	private int maxWeight;

	@Column(name = "NUMBER_OF_SEATS")
	private int numberOfSeats;

	@Column(name = "RENTED")
	private boolean rented;

	//Getters and setters

	public boolean isRented() {
		return rented;
	}

	public void setRented(boolean rented) {
		this.rented = rented;
	}

	public int getNumberOfSeats() {
		return numberOfSeats;
	}

	public int getMaxWeight() {
		return maxWeight;
	}

	public void setMaxWeight(int maxWeight) {
		this.maxWeight = maxWeight;
	}

	public void setNumberOfSeats(int numberOfSeats) {
		this.numberOfSeats = numberOfSeats;
	}

	public Vehicle() {
		super();
		this.numberOfSeats = 5;
		this.maxWeight = 300;
	}
	public Vehicle(long plateNumber) {
		this.plateNumber = plateNumber;
	}

	public long getPlateNumber() {
		return this.plateNumber;
	}
	public void setPlateNumber(long plateNumber) {
		this.plateNumber = plateNumber;
	}

	@Override
	public String toString() {
		return "Vehicule [plateNumber=" + plateNumber +"]";
	}
}
