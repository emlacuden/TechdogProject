package com.techdog.model.entities;

public class Image {
	private int image_Id;
	private int person_Id;
	private String path;
	public Image() {
		// TODO Auto-generated constructor stub
	}
	public Image(int id, int person_Id, String path) {
		super();
		this.image_Id = id;
		this.person_Id = person_Id;
		this.path = path;
	}
	public int getId() {
		return image_Id;
	}
	public void setId(int id) {
		this.image_Id = id;
	}
	public int getPerson_Id() {
		return person_Id;
	}
	public void setPerson_Id(int person_Id) {
		this.person_Id = person_Id;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	
}
