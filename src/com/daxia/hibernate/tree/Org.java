package com.daxia.hibernate.tree;

/*
 * 树结构
 */
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Org {

	private int id;
	private String name;
	private Set<Org> children = new HashSet<Org>();
	private Org parent;
	
	@OneToMany(
			cascade=(CascadeType.ALL),
			mappedBy="parent") //mappedBy 字段
	public Set<Org> getChildren() {
		return children;
	}
	public void setChildren(Set<Org> children) {
		this.children = children;
	}
	
	@ManyToOne
	@JoinColumn(name="parent_id")
	public Org getParent() {
		return parent;
	}
	public void setParent(Org parent) {
		this.parent = parent;
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
