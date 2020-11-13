package com.example.jpaProject.model;

import javax.persistence.*;

@Entity
@Table(name = "PERSON")
public class Person {
	//Columns
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@Column(name = "NAME")
	private String name;
	@Column(name = "AGE")
	private int age;

	public Person() {
		super();
	}

	public Person(String name, int age) {
		super();
		this.name 	= name;
		this.age 	= age;
	}

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", age=" + age + "]";
	}
}
