package com.daxia.hibernate.model;

import java.io.Serializable;

//联合主键：id，name
//需要实现Serializable
//需要重写equals和hashCode方法
public class Student2PK implements Serializable{
	private int id;
	private String name;
	
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
	
	@Override
	public boolean equals(Object o){
		if(o instanceof Student2PK){
			Student2PK pk = (Student2PK) o;
			if(this.id == pk.getId() && this.name.equals(pk.getName())){
				return true;
			}
		}
		return false;
	}
	
	@Override
	public int hashCode(){
		return this.name.hashCode();
	}
}
