package com.daxia.hibernate.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.TableGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
// 表生成器
@TableGenerator(
		name = "GEN",
		// id表生成器表
		table = "ID_GEN", 
		// primary key ColumnName : 此表第一个字段名：GEN_KEY
		pkColumnName = "GEN_KEY", 
		// primary key value ColumnName:此表第二个字段名：GEN_VALUE
		valueColumnName = "GEN_VALUE", 
		// 添加表数据：“Teacher” 到第一个字段(一条记录)
		pkColumnValue = "Teacher", 
		// 每次id加1
		allocationSize = 1)
					
public class Teacher {

	private TeacherPK pk;
	
	private String title;
	private Date birthDate;
	private ZhiCheng zhiCheng;
	
	//联合主键
	@Id 
	public TeacherPK getPk() {
		return pk;
	}

	public void setPk(TeacherPK pk) {
		this.pk = pk;
	}
	// 自定义枚举类型
	@Enumerated(EnumType.STRING)
	public ZhiCheng getZhiCheng() {
		return zhiCheng;
	}

	public void setZhiCheng(ZhiCheng zhiCheng) {
		this.zhiCheng = zhiCheng;
	}

	@Temporal(TemporalType.DATE)
	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date date) {
		this.birthDate = date;
	}

	/*@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "GEN")
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
	}*/

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
}
