package com.daxia.hibernate.hql;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="bbs_topic")
public class Topic {

	private int id;
	private String name;
	private Category category;
	private List<Msg> msgs = new ArrayList<Msg>();
	//获取整个帖子
	@OneToMany(mappedBy="topic")
	public List<Msg> getMsgs() {
		return msgs;
	}
	public void setMsgs(List<Msg> msgs) {
		this.msgs = msgs;
	}
	private Date createDate;
	
	
	@ManyToOne(fetch=FetchType.LAZY)
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
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
