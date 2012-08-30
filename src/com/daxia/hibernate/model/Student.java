package com.daxia.hibernate.model;

public class Student {
	//联合主键，pk是Student一部分
	private StudentPK pk;
	private int age;
	
	public StudentPK getPk() {
		return pk;
	}
	public void setPk(StudentPK pk) {
		this.pk = pk;
	}
	
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
}
