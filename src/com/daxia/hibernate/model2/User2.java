package com.daxia.hibernate.model2;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="t_user2")
public class User2 {

	private int id;
	private String name;
	private Group2 group2;
	
	@ManyToOne
	public Group2 getGroup2() {
		return group2;
	}
	public void setGroup2(Group2 group2) {
		this.group2 = group2;
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
	
}
