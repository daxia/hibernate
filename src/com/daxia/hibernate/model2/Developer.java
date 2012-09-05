package com.daxia.hibernate.model2;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/*
 * 组件映射
 */
@Entity
public class Developer {

	private int id;
	private String name;
	private int age;
	private String nationality;
	
	private Language lanuage; //使用开发语言
	@Embedded
	public Language getLanuage() {
		return lanuage;
	}
	public void setLanuage(Language lanuage) {
		this.lanuage = lanuage;
	}
	
	@Id
	@GeneratedValue
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
	
	
	public String getNationality() {
		return nationality;
	}
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
}
