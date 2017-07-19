package com.techdog.model.entities;

public class Person {
	private int person_Id;
	private String person_Name;
	public Person() {
		// TODO Auto-generated constructor stub
	}
	
	public Person(int id, String name) {
		super();
		this.person_Id = id;
		this.person_Name = name;
	}
	
	public int getId() {
		return person_Id;
	}
	public void setId(int id) {
		this.person_Id = id;
	}
	public String getName() {
		return person_Name;
	}
	public void setName(String name) {
		this.person_Name = name;
	}
	
}
