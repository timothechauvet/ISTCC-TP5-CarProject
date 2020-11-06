package com.example.jpaProject.model;

import javax.persistence.*;

@Entity
public class Vehicule {
	private long plateNumber;

	public Vehicule() {
		super();
	}
	public Vehicule(long plateNumber) {
		this.plateNumber = plateNumber;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
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
