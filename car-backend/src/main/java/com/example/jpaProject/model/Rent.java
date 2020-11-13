package com.example.jpaProject.model;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Rent {
	private Date beginRent;
	private Date endRent;
	private Vehicle vehicle;
	private Person person;

	//ID
	private int id;

	public void setId(int id) {
		this.id = id;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int getId() {
		return id;
	}

	//CTOR
	public Rent(Date begin, Date end) {
		super();
		this.beginRent	= begin;
		this.endRent	= end;
	}

	public Rent() {
		super();
	}

	public Date getBeginRent() {
		return beginRent;
	}

	public void setBeginRent(Date beginRent) {
		this.beginRent = beginRent;
	}

	public Date getEndRent() {
		return endRent;
	}

	public void setEndRent(Date endRent) {
		this.endRent = endRent;
	}

	@ManyToOne
	public Vehicle getVehicule() {
		return vehicle;
	}
	public void setVehicule(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	@ManyToOne
	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}
}
