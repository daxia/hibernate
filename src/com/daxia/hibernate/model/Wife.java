package com.daxia.hibernate.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/*
 * one-to-one
 */
@Entity
public class Wife {
	private int id;
	private String name;
	private Husband hus;
	
	@OneToOne(mappedBy="wife")
	public Husband getHus() {
		return hus;
	}

	public void setHus(Husband hus) {
		this.hus = hus;
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
