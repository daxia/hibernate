package com.daxia.hibernate.model;

import javax.persistence.Id;

public class Student2 {
	//联合主键，pk是Student一部分
	private Student2PK pk;
	private int age;
	
	
	public Student2PK getPk() {
		return pk;
	}
	public void setPk(Student2PK pk) {
		this.pk = pk;
	}
	
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
}
