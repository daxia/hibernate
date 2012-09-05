package com.daxia.hibernate.model2;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/*
 * 一对多： group->user
 */
@Entity
@Table(name="t_group2")
public class Group2 {

	private int id;
	private String name;
	//Set不会重复
	private Set<User2> user2 = new HashSet<User2>();
	
	@OneToMany(mappedBy="group2")
	public Set<User2> getUser2() {
		return user2;
	}
	public void setUser2(Set<User2> user2) {
		this.user2 = user2;
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
