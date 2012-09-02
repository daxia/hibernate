package com.daxia.hibernate.model;

public class Developer {

	private int id;
	private String name;
	private int age;
	private String programLanuage; //使用开发语言
	private String nationality;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
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
	public String getProgramLanuage() {
		return programLanuage;
	}
	public void setProgramLanuage(String programLanuage) {
		this.programLanuage = programLanuage;
	}
	public String getNationality() {
		return nationality;
	}
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
}
