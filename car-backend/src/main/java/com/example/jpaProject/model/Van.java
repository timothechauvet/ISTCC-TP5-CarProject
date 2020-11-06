package com.example.jpaProject.model;

import javax.persistence.*;

@Entity
public class Van extends Vehicule {
	private int maxWeight;

	public int getMaxWeight() {
		return maxWeight;
	}

	public void setMaxWeight(int maxWeight) {
		this.maxWeight = maxWeight;
	}

	public Van(int max) {
		super();
		this.maxWeight = max;
	}

	public Van() {
		super();
		maxWeight = 300;
	}

}
