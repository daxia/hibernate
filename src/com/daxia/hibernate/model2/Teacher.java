package com.daxia.hibernate.model2;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/*
 * 多对多关联：teacher->student
 */
@Entity
@Table(name="t_teacher")
public class Teacher {
	private int id;
	private String name;
	private Set<Student> students = new HashSet<Student>();
	
	@ManyToMany
	//设置中间表
	@JoinTable(name="t_s", //表名
			joinColumns={@JoinColumn(name="teacher_id")}, //teacher：joinColumns，这个表
			inverseJoinColumns={@JoinColumn(name="student_id")}//student：invercejoinColumns,反转表
			) 
	public Set<Student> getStudents() {
		return students;
	}
	public void setStudents(Set<Student> students) {
		this.students = students;
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
