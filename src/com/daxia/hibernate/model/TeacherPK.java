package com.daxia.hibernate.model;

import javax.persistence.Embeddable;

//联合主键：id，name
//需要实现Serializable
//需要重写equals和hashCode方法
@Embeddable  //可嵌入对象
public class TeacherPK implements java.io.Serializable{
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
		if(o instanceof TeacherPK){
			TeacherPK pk = (TeacherPK) o;
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
