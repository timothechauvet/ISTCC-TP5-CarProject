package com.example.jpaProject.model;
import javax.persistence.*;

@Entity
public class Car extends Vehicule{
	private int numberOfSeats;

	public int getNumberOfSeats() {
		return numberOfSeats;
	}

	public void setNumberOfSeats(int numberOfSeats) {
		this.numberOfSeats = numberOfSeats;
	}

	public Car(int nbrSeats) {
		super();
		this.numberOfSeats = nbrSeats;
	}

	public Car() {
		super();
		numberOfSeats = 5;
	}

}
