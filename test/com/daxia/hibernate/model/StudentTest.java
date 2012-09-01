package com.daxia.hibernate.model;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class StudentTest {
	private static SessionFactory sf;
	
	@BeforeClass
	public static void beforeClass(){
		sf = new Configuration().configure().buildSessionFactory();
	}
	
	//test.session.save()
	@Test
	public void testSave(){
		Student stu = new Student();
		stu.setAge(22);
		stu.setName("hujing");
		
		Session s = sf.getCurrentSession();
		s.beginTransaction();
		s.save(stu);
		s.getTransaction().commit();
	}
	
	//test session.delete()
	@Test
	public void testDelete(){
		Student stu = new Student();
		stu.setName("hujing");
		stu.setAge(22);
		Session s = sf.getCurrentSession();
		s.beginTransaction();
		s.save(stu);
		s.getTransaction().commit();
		
		//删除数据
		Session s2 = sf.getCurrentSession();
		s2.beginTransaction();
		s2.delete(stu);
		s2.getTransaction().commit();
	}
	
	//test session.get()
	@Test
	public void testGet(){
		
		Session s = sf.getCurrentSession();
		s.beginTransaction();
		Student stu2 = (Student) s.get(Student.class, 4);
		System.out.println(stu2.getName());
		s.getTransaction().commit();
	}
	
	//test session.load()
	@Test
	public void testLoad(){
		
		Session s = sf.getCurrentSession();
		s.beginTransaction();
		//代理 Proxy load()   第二个参数：id
		Student stu2 = (Student) s.load(Student.class, 4);
		System.out.println(stu2.getName());
		s.getTransaction().commit();
	}
	
	
	//test session.update()   先获取表数据，然后更新需要更新的表数据字段
	@Test
	public void testUpdate(){
		
		//获取表数据
		Session s = sf.getCurrentSession();
		s.beginTransaction();
		Student stu2 = (Student) s.get(Student.class, 1);
		s.getTransaction().commit();
		
		//更新表字段
		stu2.setName("zhang");
		
		//update
		Session s2 = sf.getCurrentSession();
		s2.beginTransaction();
		s2.update(stu2);
		s2.getTransaction().commit();
	}
	
	//update 至少需要知道id
	@Test
	public void testUpdate2(){
		Student stu = new Student();
		stu.setId(1);
		
		stu.setName("wang");
		Session s = sf.getCurrentSession();
		s.beginTransaction();
		s.update(stu);
		s.getTransaction().commit();
		
	}
	
	//只更新部分字段
	@Test
	public void testUpdate4(){
		Session s = sf.getCurrentSession();
		s.beginTransaction();
		//HQL:Student是对象，非表
		Query q = s.createQuery("update Student s set s.name='hu' where s.id=1");
		q.executeUpdate();
		s.getTransaction().commit();
	}
	@AfterClass
	public static void afterClass(){
		sf.close();
	}
}
