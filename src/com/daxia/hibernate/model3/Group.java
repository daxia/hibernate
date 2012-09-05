package com.daxia.hibernate.model3;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


/**
 * CRUD
 * 双向关联 
 * @author Administrator
 *
 */
@Entity
@Table(name = "t_group")
// mysql中group是关键词
public class Group {
	private int id;
	private String name;
	private String peopleNum;
	private Set<User> users = new HashSet<User>();
	
	@OneToMany(mappedBy="group",
			cascade=(CascadeType.ALL),
			fetch=(FetchType.EAGER))
	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
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

	public String getPeopleNum() {
		return peopleNum;
	}

	public void setPeopleNum(String peopleNum) {
		this.peopleNum = peopleNum;
	}
}
